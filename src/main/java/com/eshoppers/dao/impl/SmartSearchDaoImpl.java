package com.eshoppers.dao.impl;

import com.eshoppers.dao.SmartSearchDao;
import com.eshoppers.model.Customer;
import com.eshoppers.model.SearchItem;
import com.eshoppers.model.SmartSearch;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class SmartSearchDaoImpl implements SmartSearchDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public SmartSearch createSmartSearch(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        SmartSearch newSmartSearch = new SmartSearch();
        newSmartSearch.setConsumer("");
        newSmartSearch.setSmartSearchInput("");
        newSmartSearch.setAge(0);
        newSmartSearch.setBudget(0);
        newSmartSearch.setGender("");
        newSmartSearch.setRelationship("");
        newSmartSearch.setCustomer(customer);
        newSmartSearch.setCart(customer.getCart());

        SearchItem searchItem = new SearchItem();
        searchItem.setSmartSearch(newSmartSearch);

        customer.setSmartSearch(newSmartSearch);

        session.saveOrUpdate(searchItem);
        session.saveOrUpdate(newSmartSearch);
        session.saveOrUpdate(customer);
        session.flush();
        return newSmartSearch;
    }

    @Override
    public void addSearchInput(SmartSearch smartSearch) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(smartSearch);
        session.flush();
    }

    @Override
    public List<SmartSearch> getSmartSearch() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from SmartSearch");
        List<SmartSearch> smartSearch = query.list();
        session.flush();
        return smartSearch;
    }

    @Override
    public SmartSearch getSmartSearchById(int id) {
        Session session = sessionFactory.getCurrentSession();
        SmartSearch smartSearch = (SmartSearch) session.get(SmartSearch.class, id);
        session.flush();
        return smartSearch;
    }

    @Override
    public void saveSmartSearch(SmartSearch smartSearch) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(smartSearch);
        session.flush();
    }

    @Override
    public List<SmartSearch> getSmartSearch(int cartId, int customerId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from SmartSearch where cartId=? and customerId=?");
        query.setInteger(0, cartId);
        query.setInteger(1, customerId);
        List<SmartSearch> smartSearch = (List<SmartSearch>) query.list();
        session.flush();
        return smartSearch;
    }

    @Override
    public void clearSmartItems(int searchId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from SearchItem where searchId = ?");
        query.setInteger(0, searchId);
        List<SearchItem> searchItems = (List<SearchItem>) query.list();
        for (SearchItem searchItem : searchItems) {
            session.delete(searchItem);
        }
        session.flush();
    }
}