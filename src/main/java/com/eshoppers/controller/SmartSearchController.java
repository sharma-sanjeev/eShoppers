package com.eshoppers.controller;

import com.eshoppers.model.Customer;
import com.eshoppers.model.Product;
import com.eshoppers.model.SmartSearch;
import com.eshoppers.service.CustomerService;
import com.eshoppers.service.impl.smartSearchImpl.RankingAlgorithmServiceImpl;
import com.eshoppers.service.smartSearch.SmartPageOneService;
import com.eshoppers.service.smartSearch.SmartPageThreeService;
import com.eshoppers.service.smartSearch.SmartPageTwoService;
import com.eshoppers.service.smartSearch.SmartSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class SmartSearchController {

    @Autowired
    private SmartSearchService smartSearchService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SmartPageOneService smartPageOne;
    @Autowired
    private SmartPageTwoService smartPageTwo;
    @Autowired
    private SmartPageThreeService smartPageThree;
    @Autowired
    private RankingAlgorithmServiceImpl rankingAlgorithmService;

    @RequestMapping(value = "/search/input")
    public String smartSearchInput(
            @AuthenticationPrincipal User activeUser,
            Model model) {
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        SmartSearch smartSearch = customer.getSmartSearch();
        model.addAttribute("smartSearch", smartSearch);
        return "smartSearchInput";
    }

    @RequestMapping(value = "/search/input", method = RequestMethod.POST)
    public String smartSearchInput(
            @AuthenticationPrincipal User activeUser,
            @ModelAttribute("smartSearch") SmartSearch smartSearch,
            Model model) {
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        smartSearch.setCart(customer.getCart());
        smartSearch.setCustomer(customer);
        smartSearchService.addSearchInput(smartSearch);
        return "smartSearchThankYou";
    }

    @RequestMapping(value = "/search")
    public String smartSearch(
            @AuthenticationPrincipal User activeUser,
            Model model, HttpServletRequest request) {
        if (activeUser == null) {
            return "login";
        }
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        SmartSearch smartSearch = smartSearchService.getSmartSearchById(customer.getSmartSearch().getSearchId());
        String name = customerService.getProperCustomerName(customer);
        request.getSession().setAttribute("name", name);

        SmartSearch clearSmartSearch = smartSearchService.clearSmartSearch(smartSearch);
        smartSearchService.saveSmartSearch(clearSmartSearch);
        model.addAttribute("smartSearch", clearSmartSearch);
        return "smartSearch";
    }

    @RequestMapping(value = "/search/pageOne", method = RequestMethod.GET)
    public String searchAlgorithmPageOne(
            @Valid
            @AuthenticationPrincipal User activeUser,
            @ModelAttribute("smartSearch") SmartSearch smartSearch,
            HttpServletRequest request,
            Model model) {
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        SmartSearch customerSmartSearch = smartSearchService.getSmartSearchById(customer.getSmartSearch().getSearchId());

        customerSmartSearch.setSmartSearchInput(smartSearch.getSmartSearchInput());
        smartSearchService.saveSmartSearch(customerSmartSearch);

        smartPageOne.smartSearchInput(customerSmartSearch, request);

        List<Product> products = rankingAlgorithmService.productAsPerRanking(customerSmartSearch);
        model.addAttribute("products", products);
        model.addAttribute("smartSearch", smartSearch);
        return "smartSearchBudgetDetails";
    }

    @RequestMapping(value = "/search/pageTwo", method = RequestMethod.GET)
    public String searchAlgorithmPageTwo(
            @Valid
            @AuthenticationPrincipal User activeUser,
            @ModelAttribute("smartSearch") SmartSearch smartSearch,
            Model model) {
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        SmartSearch customerSmartSearch = smartSearchService.getSmartSearchById(customer.getSmartSearch().getSearchId());

        customerSmartSearch.setBudget(smartSearch.getBudget());
        smartSearchService.saveSmartSearch(customerSmartSearch);
        smartPageTwo.budgetFilter(customerSmartSearch);

        List<Product> products = rankingAlgorithmService.productAsPerRanking(customerSmartSearch);
        model.addAttribute("products", products);
        model.addAttribute("smartSearch", smartSearch);
        return "smartSearchAgeDetails";
    }

    @RequestMapping(value = "/search/pageThree", method = RequestMethod.GET)
    public String searchAlgorithmPageThree(
            @Valid
            @AuthenticationPrincipal User activeUser,
            @ModelAttribute("smartSearch") SmartSearch smartSearch,
            Model model) {
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        SmartSearch customerSmartSearch = smartSearchService.getSmartSearchById(customer.getSmartSearch().getSearchId());

        int i = smartSearch.getAge();
        customerSmartSearch.setAge(i);
        smartSearchService.saveSmartSearch(customerSmartSearch);
        smartPageThree.ageFilter(customerSmartSearch);

        List<Product> rankedProducts = rankingAlgorithmService.productAsPerRanking(customerSmartSearch);
        model.addAttribute("products", rankedProducts);
        return "smartSearchResults";
    }
}