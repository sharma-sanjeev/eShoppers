package com.eshoppers.dao;

import com.eshoppers.model.Product;
import com.eshoppers.model.SearchItem;
import com.eshoppers.model.SmartSearch;

import java.util.List;

public interface SearchItemDao {

    void addSearchItem(SearchItem searchItem);

    void removeSearchItem(SearchItem searchItem);

    List<Product> getAllProducts(SmartSearch smartSearch);

    List<SearchItem> getSearchItemByProductId(int searchId, int productId);

    void addAllSearchItem(List<SearchItem> searchItems);

    List<SearchItem> getSearchItemsById(int smartSearchId);

    List<Product> getProductListAsPerAge(SmartSearch smartSearch);

    void saveProductInSearchItem(Integer productId, int searchId);

    void removeSimilarSearchItems(SearchItem searchItem);
}
