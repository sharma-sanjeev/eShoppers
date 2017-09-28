package com.eshoppers.service.smartSearch;

import com.eshoppers.model.Customer;
import com.eshoppers.model.SmartSearch;

import java.util.List;

public interface SmartSearchService {

    void addSearchInput(SmartSearch smartSearch);

    List<SmartSearch> getSmartSearch();

    SmartSearch createSmartSearch(Customer customer);

    void saveSmartSearch(SmartSearch smartSearch);

    List<SmartSearch> getSmartSearch(int cartId, int customerId);

    SmartSearch getSmartSearchById(int id);

    SmartSearch clearSmartSearch(SmartSearch smartSearch);

}
