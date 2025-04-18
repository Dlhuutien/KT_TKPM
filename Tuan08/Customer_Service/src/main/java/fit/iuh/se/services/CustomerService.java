package fit.iuh.se.services;

import java.util.List;

import fit.iuh.se.models.dtos.CustomerDTO;

public interface CustomerService {
	List<CustomerDTO> getAll();

	CustomerDTO save(CustomerDTO dto);

	void delete(int id);

	CustomerDTO update(int id, CustomerDTO dto);
	
	CustomerDTO findById(int id) ;
}
