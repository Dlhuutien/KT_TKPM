package fit.iuh.se.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fit.iuh.se.models.dtos.CustomerDTO;
import fit.iuh.se.models.entities.Customer;
import fit.iuh.se.models.repositories.CustomerRepository;
import fit.iuh.se.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<CustomerDTO> getAll() {
		return repo.findAll().stream().map(c -> mapper.map(c, CustomerDTO.class)).collect(Collectors.toList());
	}
	
	@Override
    public CustomerDTO findById(int id) {
        return repo.findById(id)
            .map(customer -> mapper.map(customer, CustomerDTO.class))
            .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

	@Override
	public CustomerDTO save(CustomerDTO dto) {
		return mapper.map(repo.save(mapper.map(dto, Customer.class)), CustomerDTO.class);
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id); 
	}

	@Override
	public CustomerDTO update(int id, CustomerDTO dto) {
	    Customer existing = repo.findById(id).orElseThrow();
	    
	    existing.setName(dto.getName());
	    existing.setEmail(dto.getEmail());
	    existing.setAddress(dto.getAddress());
	    existing.setPhone(dto.getPhone());

	    return mapper.map(repo.save(existing), CustomerDTO.class);
	}


}
