package fit.iuh.se.services.Impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fit.iuh.se.models.dtos.OrderDTO;
import fit.iuh.se.models.entities.Order;
import fit.iuh.se.models.repositories.OrderRepository;
import fit.iuh.se.services.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository repo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private RestTemplate restTemplate;

	@Value("${api.gateway.url}")
	private String apiGatewayUrl;

	@Override
	public List<OrderDTO> getAll() {
		return repo.findAll().stream().map(o -> mapper.map(o, OrderDTO.class)).collect(Collectors.toList());
	}

	@Override
	public OrderDTO save(OrderDTO dto) {
	    // Kiểm tra customer tồn tại
		checkCustomerExists(dto.getCustomerId());
	    checkProductExists(dto.getProductId());
	    
	    Order order = mapper.map(dto, Order.class);
	    return mapper.map(repo.save(order), OrderDTO.class);
	}


	@Override
	public void delete(int id) {
		repo.deleteById(id);
	}

	@Override
	public OrderDTO update(int id, OrderDTO dto) {
	    Order existing = repo.findById(id).orElseThrow();

	    // dùng Resilience4j
	    checkCustomerExists(dto.getCustomerId()); 
	    checkProductExists(dto.getProductId());

	    existing.setCustomerId(dto.getCustomerId());
	    existing.setProductId(dto.getProductId());
	    existing.setOrderDate(LocalDate.now());
	    existing.setTotalAmount(dto.getTotalAmount());

	    return mapper.map(repo.save(existing), OrderDTO.class);
	}
	
	
	//Resilience4j
	@CircuitBreaker(name = "customerService", fallbackMethod = "fallbackCustomer")
	@Retry(name = "customerService")
	private void checkCustomerExists(int customerId) {
	    try {
	        restTemplate.getForEntity(apiGatewayUrl + "/customers/" + customerId, String.class);
	    } catch (Exception e) {
	        throw new RuntimeException("Customer ID " + customerId + " không tồn tại hoặc bị lỗi.");
	    }
	}

	@CircuitBreaker(name = "productService", fallbackMethod = "fallbackProduct")
	@Retry(name = "productService")
	private void checkProductExists(int productId) {
		try {
			restTemplate.getForEntity(apiGatewayUrl + "/products/" + productId, String.class);			
		} catch (Exception e) {
			 throw new RuntimeException("Product ID " + productId + " không tồn tại hoặc bị lỗi.");
		}
	}
	
	@SuppressWarnings("unused")
	private void fallbackCustomer(int customerId, Throwable t) {
	    throw new RuntimeException("Customer service đang lỗi hoặc không phản hồi.");
	}

	@SuppressWarnings("unused")
	private void fallbackProduct(int productId, Throwable t) {
	    throw new RuntimeException("Product service đang lỗi hoặc không phản hồi.");
	}



}
