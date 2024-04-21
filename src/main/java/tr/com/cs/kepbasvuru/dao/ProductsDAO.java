package tr.com.cs.kepbasvuru.dao;

import tr.com.cs.kepbasvuru.entity.bireysel.Products;

import java.util.List;

public interface ProductsDAO {
    List<Products> getBireyselProducts();

    Products findById(int theId);

    Products save(Products theProducts);

    void deleteById(int theId);
}
