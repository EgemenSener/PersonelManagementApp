package tr.com.cs.kepbasvuru.service;

import tr.com.cs.kepbasvuru.entity.bireysel.Products;

import java.util.List;

public interface ProductsService {
    String getProducts(Integer basvuruType);
    List<Products> findAll();

    Products findById(int theId);

    Products save(Products theProducts);

    void deleteById(int theId);
}
