package com.eshoppers.dao.impl;

import com.eshoppers.dao.CustomerOrderDao;
import com.eshoppers.model.CustomerOrder;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCustomerOrder(CustomerOrder customerOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customerOrder);
        session.flush();
    }

    @Override
    public List<CustomerOrder> getAllOrders() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CustomerOrder");
        List<CustomerOrder> customerOrders = query.list();
        session.flush();
        return customerOrders;
    }

    @Override
    public CustomerOrder getOrderById(int orderId) {
        Session session = sessionFactory.getCurrentSession();
        CustomerOrder customerOrder = (CustomerOrder) session.get(CustomerOrder.class, orderId);
        session.flush();
        return customerOrder;
    }

    @Override
    public void editCustomerOrder(CustomerOrder customerOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customerOrder);
        session.flush();
    }
}
