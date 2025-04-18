package fit.iuh.se.services;

import java.util.List;

import fit.iuh.se.models.dtos.ProductDTO;

public interface ProductService {
	List<ProductDTO> getAll();

	ProductDTO save(ProductDTO dto);

	void delete(int id);

	ProductDTO update(int id, ProductDTO dto);
	
	ProductDTO findById(int id);
}

