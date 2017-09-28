package com.eshoppers.controller;

import com.eshoppers.model.BillingAddress;
import com.eshoppers.model.Customer;
import com.eshoppers.model.ShippingAddress;
import com.eshoppers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/register")
    public String registerCustomer(Model model) {
        Customer customer = new Customer();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();
        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);
        model.addAttribute("customer", customer);
        return "registerCustomer";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerCustomerPost(
            @Valid
            @ModelAttribute("customer") Customer customer,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            return "registerCustomer";
        }
        List<Customer> customerList = customerService.getAllCustomer();
        for (Customer customerFromList : customerList) {
            if (customer.getCustomerEmail().equals(customerFromList.getCustomerEmail())) {
                model.addAttribute("emailMsg", "Email already exists.");
                return "registerCustomer";
            }
        }
        for (Customer customerFromList : customerList) {
            if (customer.getUsername().equals(customerFromList.getUsername())) {
                model.addAttribute("usernameMsg", "Username already exists.");
                return "registerCustomer";
            }
        }
        customer.setEnabled(true);
        customer.setCreationDate(new Date());
        customerService.addCustomer(customer);
        return "registerCustomerSuccess";
    }
}
