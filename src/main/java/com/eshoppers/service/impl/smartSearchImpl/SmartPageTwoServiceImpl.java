package com.eshoppers.service.impl.smartSearchImpl;

import com.eshoppers.model.SearchItem;
import com.eshoppers.model.SmartSearch;
import com.eshoppers.service.smartSearch.SearchItemService;
import com.eshoppers.service.smartSearch.SmartPageTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SmartPageTwoServiceImpl implements SmartPageTwoService {

    @Autowired
    private SearchItemService searchItemService;

    @Override
    public void budgetFilter(SmartSearch smartSearch) {
        double budget = smartSearch.getBudget();
        int i = smartSearch.getSearchId();
        List<SearchItem> searchItems = searchItemService.getSearchItemsById(i);
        List<Integer> productIds = new ArrayList<>();
        for (SearchItem searchItem : searchItems) {
            int productPrice = (int) searchItem.getProduct().getProductPrice();
            for (double j = 10; j <= 50; j = j + 10) {
                int upperLimit = (int) (budget * (1 + (j / 100)));
                int lowerLimit = (int) (budget * (1 - (j / 100)));
                if (productPrice < upperLimit && productPrice > lowerLimit) {
                    productIds.add(searchItem.getProduct().getProductId());
                }
            }
            if (productPrice > (int) (budget * 1.5) || productPrice < (int) (budget * 0.5)) {
                searchItemService.removeSimilarSearchItems(searchItem);
            }
        }
//        System.out.println(productIds);
//        List<Integer> rankedProductIds = rankingAlgorithmService.frequencyRanking(productIds);
//        System.out.println(rankedProductIds);
        for (Integer productId : productIds) {
            searchItemService.saveProductInSearchItem(productId, i);
        }
    }
}