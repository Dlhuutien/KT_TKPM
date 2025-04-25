package fit.iuh.se.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private int id;
	private String title;
	private String author;
	private double price;
	private int stock;
	private String description;
}
