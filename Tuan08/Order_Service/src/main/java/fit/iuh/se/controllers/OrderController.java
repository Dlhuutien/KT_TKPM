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

import fit.iuh.se.models.dtos.OrderDTO;
import fit.iuh.se.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService service;

	@GetMapping
	public List<OrderDTO> getAll() {
		return service.getAll();
	}

	@PostMapping
	public OrderDTO create(@RequestBody OrderDTO dto) {
		return service.save(dto);
	}

	@PutMapping("/{id}")
	public OrderDTO update(@PathVariable int id, @RequestBody OrderDTO dto) {
		return service.update(id, dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		service.delete(id);
		return ResponseEntity.ok("Xóa thành công");
	}
}
