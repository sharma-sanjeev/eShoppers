package com.eshoppers.dao.impl;

import com.eshoppers.dao.SearchItemDao;
import com.eshoppers.model.Product;
import com.eshoppers.model.SearchItem;
import com.eshoppers.model.SmartSearch;
import com.eshoppers.service.ProductService;
import com.eshoppers.service.smartSearch.SmartSearchService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class SearchItemDaoImpl implements SearchItemDao {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private SmartSearchService smartSearchService;
    @Autowired
    private ProductService productService;

    @Override
    public void addSearchItem(SearchItem searchItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(searchItem);
        session.flush();
    }

    @Override
    public void removeSearchItem(SearchItem searchItem) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(searchItem);
        session.flush();
    }

    @Override
    public List<SearchItem> getSearchItemByProductId(int searchId, int productId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from SearchItem where searchId = ? and productId = ?");
        query.setInteger(0, searchId);
        query.setInteger(1, productId);
        session.flush();
        return (List<SearchItem>) query.list();
    }

    @Override
    public List<Product> getAllProducts(SmartSearch smartSearch) {
        Session session = sessionFactory.getCurrentSession();
        int smartSearchId = smartSearch.getSearchId();
        Query query = session.createQuery("from SearchItem where searchId = ?");
        query.setInteger(0, smartSearchId);
        List<SearchItem> searchItems = query.list();
        List<Product> products = new ArrayList<>();
        for (SearchItem searchItem : searchItems) {
            products.add(searchItem.getProduct());
        }
        session.flush();
        return products;
    }

    @Override
    public void addAllSearchItem(List<SearchItem> searchItems) {
        Session session = sessionFactory.getCurrentSession();
        for (SearchItem searchItem : searchItems) {
            SearchItem newSearchItem = new SearchItem();
            newSearchItem.setSmartSearch(searchItem.getSmartSearch());
            newSearchItem.setProduct(searchItem.getProduct());
            session.saveOrUpdate(newSearchItem);
            smartSearchService.saveSmartSearch(searchItem.getSmartSearch());
        }
        session.flush();//lazy
    }

    @Override
    public List<SearchItem> getSearchItemsById(int smartSearchId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from SearchItem where searchId = ?");
        query.setInteger(0, smartSearchId);
        List<SearchItem> searchItems = query.list();
        session.flush();//lazy
        return searchItems;
    }

    @Override
    public List<Product> getProductListAsPerAge(SmartSearch smart) {
        int age = smart.getAge();
        int searchId = smart.getSearchId();
        List<Product> products = new ArrayList<>();
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from SmartSearch where age > ? and age < ? and searchId != ?");
        query.setInteger(0, (age - 10));
        query.setInteger(1, (age + 10));
        query.setInteger(2, searchId);
        List<SmartSearch> smartSearches = (List<SmartSearch>) query.list();
        for (SmartSearch smartSearch : smartSearches) {
            for (SearchItem searchItem : smartSearch.getSearchItems()) {
                products.add(searchItem.getProduct());
            }
        }
        session.flush();//lazy
        return products;
    }

    @Override
    public void saveProductInSearchItem(Integer productId, int searchId) {
        Session session = sessionFactory.getCurrentSession();
        SearchItem searchItem = new SearchItem();
        searchItem.setSmartSearch(smartSearchService.getSmartSearchById(searchId));
        searchItem.setProduct(productService.getProductById(productId));
        session.saveOrUpdate(searchItem);
        session.flush();
    }

    @Override
    public void removeSimilarSearchItems(SearchItem searchItem) {
        int productId = searchItem.getProduct().getProductId();
        int searchId = searchItem.getSmartSearch().getSearchId();
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from SearchItem where searchId =? and productId=?");
        query.setInteger(0, searchId);
        query.setInteger(1, productId);
        List<SearchItem> searchItems = query.list();
        for (SearchItem s : searchItems) {
            session.delete(s);
        }
        session.flush();
    }
}
