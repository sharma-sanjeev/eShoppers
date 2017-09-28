package com.eshoppers.controller.admin;

import com.eshoppers.model.Customer;
import com.eshoppers.model.CustomerOrder;
import com.eshoppers.model.Product;
import com.eshoppers.service.CustomerOrderService;
import com.eshoppers.service.CustomerService;
import com.eshoppers.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminHome {

    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerOrderService customerOrderService;

    @RequestMapping
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/productInventory")
    public String productInventory(Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);
        return "productInventory";
    }

    @RequestMapping("/user")
    public String customerManagement(Model model) {
        List<Customer> customerList = customerService.getAllCustomer();
        model.addAttribute("customerList", customerList);
        return "userManagement";
    }

    @RequestMapping("/order")
    public String orderManagement(Model model) {
        List<CustomerOrder> orderList = customerOrderService.getAllOrders();
        model.addAttribute("orderList", orderList);
        return "orderManagement";
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String orderUpdate(
            @ModelAttribute("orderId") int i,
            @ModelAttribute("status") String status,
            Model model) {
        CustomerOrder customerOrder = customerOrderService.getOrderById(i);
        customerOrder.setStatus(status);
        customerOrderService.editCustomerOrder(customerOrder);

        List<CustomerOrder> orderList = customerOrderService.getAllOrders();
        model.addAttribute("orderList", orderList);
        return "orderManagement";
    }

}