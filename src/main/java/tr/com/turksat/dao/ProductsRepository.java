package tr.com.turksat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.turksat.entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

}
