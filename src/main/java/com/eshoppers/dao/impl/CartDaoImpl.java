package com.eshoppers.dao.impl;

import com.eshoppers.dao.CartDao;
import com.eshoppers.model.Cart;
import com.eshoppers.model.Customer;
import com.eshoppers.model.SmartSearch;
import com.eshoppers.service.CustomerOrderService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.TreeSet;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private CustomerOrderService customerOrderService;

    @Override
    public Cart getCartById(int cartId) {
        Session session = sessionFactory.getCurrentSession();
        Cart cart = (Cart) session.get(Cart.class, cartId);
        session.flush();
        return cart;
    }

    @Override
    public void update(Cart cart) {
        int carId = cart.getCartId();
        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(carId);
        cart.setGrandTotal(grandTotal);

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
        session.flush();
    }

    @Override
    public Cart validate(int cartId) throws IOException {
        Cart cart = getCartById(cartId);
        if (cart == null || cart.getCartItems().size() == 0) {
            throw new IOException(cartId + " ");
        }
        update(cart);
        return cart;
    }

    @Override
    public Cart addNewCart(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);
        SmartSearch smartSearch = new SmartSearch();
        smartSearch.setCart(newCart);
        smartSearch.setCustomer(customer);
        customer.setSmartSearch(smartSearch);

        session.saveOrUpdate(smartSearch);
        session.saveOrUpdate(newCart);
        session.saveOrUpdate(customer);
        session.flush();
        return newCart;
    }

    @Override
    public Cart getLastCart(int customerId, int cartId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Cart where customerId = ?");
        query.setInteger(0, customerId);
        List<Cart> carts = ((List<Cart>) query.list());
        TreeSet<Integer> cartIds = new TreeSet<>();
        for (Cart c : carts) {
            cartIds.add(c.getCartId());
        }
        if (cartId == cartIds.pollLast()) {
            int lastCartId = cartIds.last();

            return getCartById(lastCartId);
        }
        return getCartById(cartId);
    }
}