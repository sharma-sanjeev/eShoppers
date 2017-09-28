package com.eshoppers.service;

import com.eshoppers.model.Customer;

import java.util.List;

public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomer();

    Customer getCustomerByUsername(String username);

    String getProperCustomerName(Customer customer);
}