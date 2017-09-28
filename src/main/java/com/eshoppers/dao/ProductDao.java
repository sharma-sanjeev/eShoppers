package com.eshoppers.dao;

import com.eshoppers.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(int id);

    List<Product> getInactiveProductList();
}
