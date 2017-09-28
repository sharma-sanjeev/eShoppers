package com.eshoppers.service.impl;

import com.eshoppers.dao.CustomerDao;
import com.eshoppers.model.Customer;
import com.eshoppers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    @Override
    public Customer getCustomerById(int customerId) {
        Customer customer = customerDao.getCustomerById(customerId);
        return customer;
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customers = customerDao.getAllCustomer();
        return customers;
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        return customerDao.getCustomerByUsername(username);
    }

    @Override
    public String getProperCustomerName(Customer customer) {
        String name = toTitleCase(customer.getCustomerName());
        return name;
    }

    private String toTitleCase(String input) {
        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;
        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }
            titleCase.append(c);
        }
        return titleCase.toString();
    }
}
