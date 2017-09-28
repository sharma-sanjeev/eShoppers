package com.eshoppers.service;

import com.eshoppers.model.Product;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Path;
import java.util.List;

public interface ProductService {

    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(int productId);

    List<Product> getInactiveProductList();

    Path getImagePath(Product product, HttpServletRequest request);

}