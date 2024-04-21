package tr.com.cs.kepbasvuru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.cs.kepbasvuru.dao.ProductsDAO;
import tr.com.cs.kepbasvuru.entity.bireysel.Products;

import java.util.List;

@Service
public class ProductsServiceImpl implements  ProductsService{

    private ProductsDAO productsDAO;

    @Autowired
    public ProductsServiceImpl(ProductsDAO theProductsDAO) {
        productsDAO = theProductsDAO;
    }
    @Override
    public List<Products> getBireyselProducts() {
        return productsDAO.getBireyselProducts();
    }

    @Override
    public Products findById(int theId) {
        return productsDAO.findById(theId);
    }
    @Transactional
    @Override
    public Products save(Products theProducts) {
        return productsDAO.save(theProducts);
    }
    @Transactional
    @Override
    public void deleteById(int theId) {
        productsDAO.deleteById(theId);
    }
}
