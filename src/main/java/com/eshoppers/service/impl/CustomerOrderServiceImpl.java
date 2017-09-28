package com.eshoppers.service.impl;

import com.eshoppers.dao.CustomerOrderDao;
import com.eshoppers.model.Cart;
import com.eshoppers.model.CartItem;
import com.eshoppers.model.CustomerOrder;
import com.eshoppers.service.CartService;
import com.eshoppers.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CartService cartService;

    @Override
    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.addCustomerOrder(customerOrder);
    }

    @Override
    public double getCustomerOrderGrandTotal(int cartId) {
        double grandTotal = 0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem item : cartItems) {
            grandTotal += item.getTotalPrice();
        }
        return grandTotal;
    }

    @Override
    public List<CustomerOrder> getAllOrders() {
        return customerOrderDao.getAllOrders();
    }

    @Override
    public CustomerOrder getOrderById(int orderId) {
        return customerOrderDao.getOrderById(orderId);
    }

    @Override
    public void editCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.editCustomerOrder(customerOrder);
    }
}