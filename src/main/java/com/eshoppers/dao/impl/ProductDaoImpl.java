package com.eshoppers.dao.impl;

import com.eshoppers.dao.ProductDao;
import com.eshoppers.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> getProductList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> products = new ArrayList<>();
        List<Product> productList = query.list();
        for (Product product : productList) {
            if (product.getProductStatus().equals("Active")) {
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public Product getProductById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        return product;
    }

    @Override
    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    @Override
    public void editProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    @Override
    public void deleteProduct(int productId) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getProductById(productId));
        session.flush();
    }

    @Override
    public List<Product> getInactiveProductList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> products = new ArrayList<>();
        List<Product> productList = query.list();
        for (Product product : productList) {
            if (!product.getProductStatus().equals("Active")) {
                products.add(product);
            }
        }
        return products;
    }
}