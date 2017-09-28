package com.eshoppers.service;

import com.eshoppers.model.CustomerOrder;

import java.util.List;

public interface CustomerOrderService {

    void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderGrandTotal(int cartId);

    List<CustomerOrder> getAllOrders();

    CustomerOrder getOrderById(int orderId);

    void editCustomerOrder(CustomerOrder customerOrder);


}
