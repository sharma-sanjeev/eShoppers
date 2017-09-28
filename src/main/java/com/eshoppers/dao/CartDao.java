package com.eshoppers.dao;

import com.eshoppers.model.Cart;
import com.eshoppers.model.Customer;

import java.io.IOException;

public interface CartDao {

    Cart getCartById(int cartId);

    void update(Cart cart);

    Cart validate(int cartId) throws IOException;

    Cart addNewCart(Customer customer);

    Cart getLastCart(int customerId, int cartId);
}
