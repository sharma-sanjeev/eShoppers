package com.eshoppers.service.impl.smartSearchImpl;

import com.eshoppers.model.Product;
import com.eshoppers.model.SearchItem;
import com.eshoppers.model.SmartSearch;
import com.eshoppers.service.smartSearch.SearchItemService;
import com.eshoppers.service.smartSearch.SmartPageThreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SmartPageThreeServiceImpl implements SmartPageThreeService {

    @Autowired
    private SearchItemService searchItemService;

    @Override
    public void ageFilter(SmartSearch smartSearch) {
        int i = smartSearch.getSearchId();
        List<SearchItem> searchItems = searchItemService.getSearchItemsById(i);
        List<Product> productListAsPerAge = searchItemService.getProductListAsPerAge(smartSearch);
        List<Product> commonProducts = new ArrayList<>();
        for (SearchItem searchItem : searchItems) {
            for (Product product : productListAsPerAge) {
                if (product.getProductId() == searchItem.getProduct().getProductId()) {
                    commonProducts.add(product);
                }
            }
        }
        searchItemService.addProducts(commonProducts, smartSearch);
    }
}
