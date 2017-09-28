package com.eshoppers.dao;

import com.eshoppers.model.Customer;
import com.eshoppers.model.SmartSearch;

import java.util.List;

public interface SmartSearchDao {

    SmartSearch createSmartSearch(Customer customer);

    void addSearchInput(SmartSearch smartSearch);

    List<SmartSearch> getSmartSearch();

    SmartSearch getSmartSearchById(int id);

    void saveSmartSearch(SmartSearch smartSearch);

    List<SmartSearch> getSmartSearch(int cartId, int customerId);

    void clearSmartItems(int searchId);
}
