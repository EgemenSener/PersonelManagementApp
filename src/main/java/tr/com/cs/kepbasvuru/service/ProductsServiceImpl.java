package tr.com.cs.kepbasvuru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.cs.kepbasvuru.client.SalesforceClient;
import tr.com.cs.kepbasvuru.dao.ProductsRepository;
import tr.com.cs.kepbasvuru.entity.bireysel.Products;
import tr.com.cs.kepbasvuru.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

import static tr.com.cs.kepbasvuru.constants.CommonConstants.*;

@Service
public class ProductsServiceImpl implements  ProductsService{

    private final ProductsRepository productsRepository;

    private final SalesforceClient salesforceClient;

    @Autowired
    public ProductsServiceImpl(ProductsRepository theProductsRepository, SalesforceClient theSalesforceClient) {
        productsRepository = theProductsRepository;
        salesforceClient = theSalesforceClient;
    }

    @Override
    public String getProducts(Integer basvuruType) {
        String token = salesforceClient.getBearerToken();
        return switch (basvuruType) {
            case TYPE_BIREYSEL -> salesforceClient.getProducts(token, "Bireysel");
            case TYPE_KURUMSAL -> salesforceClient.getProducts(token, "Kurumsal");
            case TYPE_KAMU -> salesforceClient.getProducts(token, "Kamu");
            default -> null;
        };
    }

    @Override
    public List<Products> findAll() {return productsRepository.findAll();}

    @Override
    public Products findById(int theId) {
        Optional<Products> result = productsRepository.findById(theId);
        Products theProduct;

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
