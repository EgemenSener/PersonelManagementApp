package tr.com.turksat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.turksat.client.SalesforceClient;
import tr.com.turksat.dao.ProductsRepository;
import tr.com.turksat.entity.Personel;
import tr.com.turksat.exception.NotFoundException;
import tr.com.turksat.constants.CommonConstants;

import java.util.List;
import java.util.Optional;

@Service
public class PersonelServiceImpl implements PersonelService {

    private final ProductsRepository productsRepository;

    private final SalesforceClient salesforceClient;

    @Autowired
    public PersonelServiceImpl(ProductsRepository theProductsRepository, SalesforceClient theSalesforceClient) {
        productsRepository = theProductsRepository;
        salesforceClient = theSalesforceClient;
    }

    @Override
    public String getProducts(Integer basvuruType) {
        String token = salesforceClient.getBearerToken();
        return switch (basvuruType) {
            case CommonConstants.TYPE_BIREYSEL -> salesforceClient.getProducts(token, "Bireysel");
            case CommonConstants.TYPE_KURUMSAL -> salesforceClient.getProducts(token, "Kurumsal");
            case CommonConstants.TYPE_KAMU -> salesforceClient.getProducts(token, "Kamu");
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
