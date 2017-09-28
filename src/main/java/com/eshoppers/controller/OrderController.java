package com.eshoppers.controller;

import com.eshoppers.model.Cart;
import com.eshoppers.model.Customer;
import com.eshoppers.model.CustomerOrder;
import com.eshoppers.service.CartService;
import com.eshoppers.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class OrderController {
    @Autowired
    private CartService cartService;
    @Autowired
    private CustomerOrderService customerOrderService;

    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable int cartId) {
        CustomerOrder customerOrder = new CustomerOrder();
        Cart cart = cartService.getCartById(cartId);
        customerOrder.setCart(cart);

        Customer customer = cart.getCustomer();
        customerOrder.setCustomer(customer);
        customerOrder.setBillingAddress(customer.getBillingAddress());
        customerOrder.setShippingAddress(customer.getShippingAddress());
        customerOrder.setCreationDate(new Date());
        customerOrder.setStatus("Active");

        customerOrderService.addCustomerOrder(customerOrder);
        return "redirect:/checkout?cartId=" + cartId;
    }
}