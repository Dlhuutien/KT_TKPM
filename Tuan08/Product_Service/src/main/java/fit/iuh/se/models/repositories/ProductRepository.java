package fit.iuh.se.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fit.iuh.se.models.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
