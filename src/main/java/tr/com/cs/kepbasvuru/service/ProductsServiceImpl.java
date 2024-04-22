package tr.com.cs.kepbasvuru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.cs.kepbasvuru.dao.ProductsRepository;
import tr.com.cs.kepbasvuru.entity.bireysel.Products;
import tr.com.cs.kepbasvuru.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements  ProductsService{

    private ProductsRepository productsRepository;

    @Autowired
    public ProductsServiceImpl(ProductsRepository theProductsRepository) {
        productsRepository = theProductsRepository;
    }
    @Override
    public List<Products> findAll() {return productsRepository.findAll();}

    @Override
    public Products findById(int theId) {
        Optional<Products> result = productsRepository.findById(theId);
        Products theProduct = null;

        if(result.isPresent()) {
            theProduct = result.get();
        } else {
            throw new NotFoundException("Did not found product " + theId);
        }
        return theProduct;
    }

    @Override
    public Products save(Products theProducts) {
        return productsRepository.save(theProducts);
    }

    @Override
    public void deleteById(int theId) {
        productsRepository.deleteById(theId);
    }
}
