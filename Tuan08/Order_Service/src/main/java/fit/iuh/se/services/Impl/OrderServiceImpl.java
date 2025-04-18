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
	    ResponseEntity<String> customerResponse = restTemplate.getForEntity(
	        apiGatewayUrl + "/customers/" + dto.getCustomerId(), String.class);

	    if (!customerResponse.getStatusCode().is2xxSuccessful()) {
	        throw new RuntimeException("Customer not found: " + dto.getCustomerId());
	    }

	    // Kiểm tra product tồn tại
	    ResponseEntity<String> productResponse = restTemplate.getForEntity(
	        apiGatewayUrl + "/products/" + dto.getProductId(), String.class);

	    if (!productResponse.getStatusCode().is2xxSuccessful()) {
	        throw new RuntimeException("Product not found: " + dto.getProductId());
	    }

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

	    try {
	        restTemplate.getForEntity(apiGatewayUrl + "/customers/" + dto.getCustomerId(), String.class);
	    } catch (Exception e) {
	        throw new RuntimeException("Customer không tồn tại với ID: " + dto.getCustomerId());
	    }

	    try {
	        restTemplate.getForEntity(apiGatewayUrl + "/products/" + dto.getProductId(), String.class);
	    } catch (Exception e) {
	        throw new RuntimeException("Product không tồn tại với ID: " + dto.getProductId());
	    }

	    existing.setCustomerId(dto.getCustomerId());
	    existing.setProductId(dto.getProductId());
	    existing.setOrderDate(LocalDate.now());
	    existing.setTotalAmount(dto.getTotalAmount());

	    return mapper.map(repo.save(existing), OrderDTO.class);
	}

}
