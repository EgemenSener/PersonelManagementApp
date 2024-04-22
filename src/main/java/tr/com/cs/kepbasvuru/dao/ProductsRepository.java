package tr.com.cs.kepbasvuru.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.cs.kepbasvuru.entity.bireysel.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

}
