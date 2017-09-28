package com.eshoppers.service;

import com.eshoppers.model.Cart;
import com.eshoppers.model.Customer;

public interface CartService {

    Cart addNewCart(Customer customer);

    Cart getCartById(int cartId);

    void update(Cart cart);

    Cart getLastCart(int customerId, int cartId);
}