package fit.iuh.se.models.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
	private int id;
	private int customerId;
	private int productId;
	private LocalDate orderDate;
	private double totalAmount;
}
