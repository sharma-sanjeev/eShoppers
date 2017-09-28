package com.eshoppers.service.impl.smartSearchImpl;

import com.eshoppers.dao.SearchItemDao;
import com.eshoppers.model.Product;
import com.eshoppers.model.SearchItem;
import com.eshoppers.model.SmartSearch;
import com.eshoppers.service.ProductService;
import com.eshoppers.service.smartSearch.SearchItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class SearchItemServiceImpl implements SearchItemService {

    @Autowired
    SearchItemDao searchItemDao;

    @Autowired
    ProductService productService;

    @Override
    public void addSearchItem(SearchItem searchItem) {
        searchItemDao.addSearchItem(searchItem);
    }

    @Override
    public void removeSearchItem(SearchItem searchItem) {
        searchItemDao.removeSearchItem(searchItem);
    }

    @Override
    public List<Product> getSearchItemByProductId(int searchId, int productId) {
        Set<Product> productSet = new LinkedHashSet<>();
        List<SearchItem> searchItems = searchItemDao.getSearchItemByProductId(searchId, productId);
        for (SearchItem searchItem : searchItems) {
            productSet.add(searchItem.getProduct());
        }
        return new ArrayList<>(productSet);
    }

    public List<Product> getAllProducts(SmartSearch smartSearch) {
        return searchItemDao.getAllProducts(smartSearch);
    }

    public void addAllSearchItem(List<SearchItem> searchItems) {
        searchItemDao.addAllSearchItem(searchItems);
    }

    @Override
    public List<SearchItem> getSearchItemsById(int smartSearchId) {
        return searchItemDao.getSearchItemsById(smartSearchId);
    }

    @Override
    public List<Product> getProductListAsPerAge(SmartSearch smartSearch) {
        return searchItemDao.getProductListAsPerAge(smartSearch);
    }

    @Override
    public void saveProductInSearchItem(Integer productId, int searchId) {
        searchItemDao.saveProductInSearchItem(productId, searchId);
    }

    @Override
    public void removeSimilarSearchItems(SearchItem searchItem) {
        searchItemDao.removeSimilarSearchItems(searchItem);
    }

    @Override
    public void addProducts(List<Product> products, SmartSearch smartSearch) {
        for (Product product : products) {
            SearchItem newSearchItem = new SearchItem();
            newSearchItem.setProduct(product);
            newSearchItem.setSmartSearch(smartSearch);
            addSearchItem(newSearchItem);
        }
    }
}