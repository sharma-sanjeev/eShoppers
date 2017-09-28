package com.eshoppers.service.impl.smartSearchImpl;

import com.eshoppers.model.Cart;
import com.eshoppers.model.CartItem;
import com.eshoppers.model.Product;
import com.eshoppers.model.SmartSearch;
import com.eshoppers.service.smartSearch.SearchItemService;
import com.eshoppers.service.smartSearch.SearchUtilService;
import com.eshoppers.service.smartSearch.SmartPageOneService;
import com.eshoppers.service.smartSearch.SmartSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class SmartPageOneServiceImpl implements SmartPageOneService {

    @Autowired
    private SmartSearchService smartSearchService;
    @Autowired
    private SearchUtilService searchUtil;
    @Autowired
    private SearchItemService searchItemService;

    @Override
    public void smartSearchInput(SmartSearch smartSearch, HttpServletRequest request) {
        String smartSearchInput = smartSearch.getSmartSearchInput();
        searchUtil.amazonProducts(smartSearchInput, request);//working on website(commented here, 'coz of amazon credentials)
        List<SmartSearch> dataSmartSearches = smartSearchService.getSmartSearch();
        List<String> splitInputString = searchUtil.splitString(smartSearchInput);
        for (SmartSearch dataSmartSearch : dataSmartSearches) {
            String smartSearchInputData = dataSmartSearch.getSmartSearchInput();
            if (searchUtil.cleanString(smartSearchInput).equals(searchUtil.cleanString(smartSearchInputData))) {
                for (int i = 0; i < 4; i++) {
                    searchItemService.addProducts(productsFromCart(dataSmartSearch), smartSearch);//Just to increase the ranking
                }
            } else {
                for (String smartString : dataFromSmartSearch(dataSmartSearch)) {
                    for (String splittedSmartSearchInput : splitInputString) {
                        if (splittedSmartSearchInput.equals(smartString)) {
                            searchItemService.addProducts(productsFromCart(dataSmartSearch), smartSearch);
                        }
                    }
                }
            }
        }
        List<Product> productNameAndCategorySearch = searchUtil.productNameSearch(smartSearchInput);
        searchItemService.addProducts(productNameAndCategorySearch, smartSearch);
        searchUtil.brandNameSearch(smartSearch);
    }

    public List<String> dataFromSmartSearch(SmartSearch smartSearch) {
        List<String> smartSearchInString = searchUtil.splitString(smartSearch.getSmartSearchInput());
        String consumer = searchUtil.cleanString(smartSearch.getConsumer());
        String relationship = searchUtil.cleanString(smartSearch.getRelationship());
        smartSearchInString.add(consumer);
        smartSearchInString.add(relationship);
        return smartSearchInString;
    }

    public List<Product> productsFromCart(SmartSearch smartSearch) {
        Cart cart = smartSearch.getCart();
        Set<Product> uniqueProducts = new LinkedHashSet<>();
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem : cartItems) {
            uniqueProducts.add(cartItem.getProduct());
        }
        return new ArrayList<>(uniqueProducts);
    }
}