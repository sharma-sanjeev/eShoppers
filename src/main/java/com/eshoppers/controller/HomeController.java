package com.eshoppers.controller;

import com.eshoppers.model.Customer;
import com.eshoppers.model.Product;
import com.eshoppers.service.CustomerService;
import com.eshoppers.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/")
    public String home(Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);
        return "index";
    }

    @RequestMapping("/login")
    public String login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            Model model, HttpServletRequest request) {
        if (error != null) {
            model.addAttribute("error", "Invalid username and password");
        }
        if (logout != null) {
            model.addAttribute("msg", "You have logged out successfully");
        }
        if (request.getUserPrincipal() != null) {
            Customer customer = customerService.getCustomerByUsername(request.getUserPrincipal().getName());
            String name = customerService.getProperCustomerName(customer);
            request.getSession().setAttribute("name", name);
        }
        return "login";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }
}