package com.eshoppers.service.impl;

import com.eshoppers.dao.CartDao;
import com.eshoppers.model.Cart;
import com.eshoppers.model.Customer;
import com.eshoppers.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Override
    public Cart addNewCart(Customer customer) {
        return cartDao.addNewCart(customer);
    }

    @Override
    public Cart getCartById(int cartId) {
        return cartDao.getCartById(cartId);
    }

    @Override
    public void update(Cart cart) {
        cartDao.update(cart);
    }

    public Cart getLastCart(int customerId, int cartId) {
        return cartDao.getLastCart(customerId, cartId);
    }

}
