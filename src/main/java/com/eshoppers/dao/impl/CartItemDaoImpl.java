package com.eshoppers.dao.impl;

import com.eshoppers.dao.CartItemDao;
import com.eshoppers.model.Cart;
import com.eshoppers.model.CartItem;
import com.eshoppers.model.Customer;
import com.eshoppers.service.CartService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private CartService cartService;

    @Override
    public void addCartItem(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
        session.flush();
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(cartItem);
        session.flush();
    }

    @Override
    public void newCart(Cart cart) {
        Customer customer = cart.getCustomer();
        customer.setCart(cartService.addNewCart(customer));
    }

    @Override
    public CartItem getCartItemByProductId(int cartId, int productId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartItem where cartId = ? and productId = ?");
        query.setInteger(0, cartId);
        query.setInteger(1, productId);
        session.flush();
        return (CartItem) query.uniqueResult();
    }
}
