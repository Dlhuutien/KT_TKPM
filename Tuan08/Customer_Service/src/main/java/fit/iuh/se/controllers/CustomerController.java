package fit.iuh.se.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fit.iuh.se.models.dtos.CustomerDTO;
import fit.iuh.se.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService service;

	@GetMapping
	public List<CustomerDTO> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public CustomerDTO getById(@PathVariable int id) {
		return service.findById(id);
	}

	@PostMapping
	public CustomerDTO create(@RequestBody CustomerDTO dto) {
		return service.save(dto);
	}

	@PutMapping("/{id}")
	public CustomerDTO update(@PathVariable int id, @RequestBody CustomerDTO dto) {
		return service.update(id, dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		service.delete(id);
		return ResponseEntity.ok("Xóa thành công");
	}

}
