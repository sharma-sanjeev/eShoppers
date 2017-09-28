package com.eshoppers.service.smartSearch;


import com.eshoppers.model.Product;
import com.eshoppers.model.SearchItem;
import com.eshoppers.model.SmartSearch;

import java.util.List;

public interface SearchItemService {

    void addSearchItem(SearchItem searchItem);

    void removeSearchItem(SearchItem searchItem);

    List<Product> getSearchItemByProductId(int searchId, int productId);

    List<Product> getAllProducts(SmartSearch smartSearch);

    void addAllSearchItem(List<SearchItem> searchItems);

    List<SearchItem> getSearchItemsById(int smartSearchId);

    List<Product> getProductListAsPerAge(SmartSearch smartSearch);

    void saveProductInSearchItem(Integer productId, int searchId);

    void removeSimilarSearchItems(SearchItem searchItem);

    void addProducts(List<Product> products, SmartSearch smartSearch);
}