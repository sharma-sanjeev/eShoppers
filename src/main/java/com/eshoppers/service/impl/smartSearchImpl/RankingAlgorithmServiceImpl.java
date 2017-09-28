package com.eshoppers.service.impl.smartSearchImpl;

import com.eshoppers.model.Product;
import com.eshoppers.model.SmartSearch;
import com.eshoppers.service.ProductService;
import com.eshoppers.service.smartSearch.RankingAlgorithmService;
import com.eshoppers.service.smartSearch.SearchItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RankingAlgorithmServiceImpl implements RankingAlgorithmService {

    @Autowired
    private ProductService productService;
    @Autowired
    private SearchItemService searchItemService;

    public List<Product> productAsPerRanking(SmartSearch smartSearch) {
        List<Integer> productIds = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        List<Product> oldProduct = searchItemService.getAllProducts(smartSearch);

        for (Product product : oldProduct) {
            productIds.add(product.getProductId());
        }
        List<Integer> productIdsAsPerPriority = frequencyRanking(productIds);
        for (Integer i : productIdsAsPerPriority) {
            products.add(productService.getProductById(i));
        }
        return products;
    }

    public List<Integer> frequencyRanking(List<Integer> list) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer i : list) {
            counts.put(i, 1);
        }
        for (Integer i : counts.keySet()) {
            int counter = 0;
            for (Integer b : list) {
                if (i == b) {
                    counter++;
                }
            }
            counts.replace(i, counter);
        }
        List<Integer> l = new ArrayList<>();
        for (Integer key : counts.keySet()) {
            Integer highKey = 0;
            int valueCheck = 0;
            for (Integer keyChecker : counts.keySet()) {
                int valueChecker = counts.get(keyChecker);
                if (valueChecker > valueCheck) {
                    valueCheck = valueChecker;
                    highKey = keyChecker;
                }
            }
            l.add(highKey);
            counts.put(highKey, 0);
        }
        return l;
    }
}