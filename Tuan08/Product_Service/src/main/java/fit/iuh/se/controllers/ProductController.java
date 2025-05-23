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

import fit.iuh.se.models.dtos.ProductDTO;
import fit.iuh.se.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService service;

	@GetMapping
	public List<ProductDTO> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public ProductDTO getById(@PathVariable int id) {
	    return service.findById(id);
	}

	@PostMapping
	public ProductDTO create(@RequestBody ProductDTO dto) {
		return service.save(dto);
	}

	@PutMapping("/{id}")
	public ProductDTO update(@PathVariable int id, @RequestBody ProductDTO dto) {
		return service.update(id, dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		service.delete(id);
		return ResponseEntity.ok("Xóa thành công");
	}

}
