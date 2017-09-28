package com.eshoppers.service;

import com.eshoppers.model.Cart;
import com.eshoppers.model.CartItem;

public interface CartItemService {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int cartId, int productId);
}