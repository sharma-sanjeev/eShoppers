package com.eshoppers.dao;

import com.eshoppers.model.CustomerOrder;

import java.util.List;

public interface CustomerOrderDao {

    void addCustomerOrder(CustomerOrder customerOrder);

    List<CustomerOrder> getAllOrders();

    CustomerOrder getOrderById(int orderId);

    void editCustomerOrder(CustomerOrder customerOrder);
}
