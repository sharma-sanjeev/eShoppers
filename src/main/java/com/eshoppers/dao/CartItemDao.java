package com.eshoppers.dao;

import com.eshoppers.model.Cart;
import com.eshoppers.model.CartItem;

public interface CartItemDao {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void newCart(Cart cart);

    CartItem getCartItemByProductId(int cartId, int productId);

}