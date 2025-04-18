package fit.iuh.se.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fit.iuh.se.models.dtos.ProductDTO;
import fit.iuh.se.models.entities.Product;
import fit.iuh.se.models.repositories.ProductRepository;
import fit.iuh.se.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository repo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<ProductDTO> getAll() {
		return repo.findAll().stream().map(product -> mapper.map(product, ProductDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ProductDTO findById(int id) {
		return repo.findById(id).map(product -> mapper.map(product, ProductDTO.class))
				.orElseThrow(() -> new RuntimeException("Product not found"));
	}

	@Override
	public ProductDTO save(ProductDTO dto) {
		return mapper.map(repo.save(mapper.map(dto, Product.class)), ProductDTO.class);
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	@Override
	public ProductDTO update(int id, ProductDTO dto) {
		Product existing = repo.findById(id).orElseThrow();
		existing.setTitle(dto.getTitle());
		existing.setAuthor(dto.getAuthor());
		existing.setPrice(dto.getPrice());
		existing.setStock(dto.getStock());
		existing.setDescription(dto.getDescription());

		return mapper.map(repo.save(existing), ProductDTO.class);
	}


}
