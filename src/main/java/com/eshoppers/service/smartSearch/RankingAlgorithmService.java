package com.eshoppers.service.smartSearch;

import com.eshoppers.model.Product;
import com.eshoppers.model.SmartSearch;

import java.util.List;

public interface RankingAlgorithmService {

    List<Product> productAsPerRanking(SmartSearch smartSearch);

    List<Integer> frequencyRanking(List<Integer> list);

}
