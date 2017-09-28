package com.eshoppers.service.impl;

import com.eshoppers.dao.CartItemDao;
import com.eshoppers.model.Cart;
import com.eshoppers.model.CartItem;
import com.eshoppers.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDao cartItemDao;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        cartItemDao.removeCartItem(cartItem);
    }

    @Override
    public void removeAllCartItems(Cart cart) {
        cartItemDao.newCart(cart);
    }

    @Override
    public CartItem getCartItemByProductId(int cartId, int productId) {
        return cartItemDao.getCartItemByProductId(cartId, productId);
    }
}
