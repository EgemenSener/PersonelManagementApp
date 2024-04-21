package tr.com.cs.kepbasvuru.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tr.com.cs.kepbasvuru.entity.bireysel.Products;

import java.util.List;

@Repository
public class ProductsDAOJpaImpl implements ProductsDAO{

    private EntityManager entityManager;

    @Autowired
    public ProductsDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    @Override
    public List<Products> getBireyselProducts() {
        TypedQuery<Products> theQuery= entityManager.createQuery("from Products", Products.class);
        return null;
    }
}
