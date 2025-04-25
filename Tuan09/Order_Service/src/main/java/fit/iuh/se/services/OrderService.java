package fit.iuh.se.services;

import java.util.List;

import fit.iuh.se.models.dtos.OrderDTO;

public interface OrderService {
	List<OrderDTO> getAll();

	OrderDTO save(OrderDTO dto);

	void delete(int id);

	OrderDTO update(int id, OrderDTO dto);
}
