package com.eshoppers.service.impl.smartSearchImpl;

import com.eshoppers.dao.SmartSearchDao;
import com.eshoppers.model.Cart;
import com.eshoppers.model.Customer;
import com.eshoppers.model.SmartSearch;
import com.eshoppers.service.CartService;
import com.eshoppers.service.smartSearch.SmartSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartSearchServiceImpl implements SmartSearchService {

    @Autowired
    private SmartSearchDao smartSearchDao;
    @Autowired
    private CartService cartService;

    @Override
    public void addSearchInput(SmartSearch smartSearch) {
        Cart cart = cartService.getLastCart(smartSearch.getCustomer().getCustomerId(), smartSearch.getCart().getCartId());
        int i = cart.getCartId();
        int j = smartSearch.getCustomer().getCustomerId();
        List<SmartSearch> smartSearch1 = getSmartSearch(i, j);
        for (SmartSearch smartSearchUpdated : smartSearch1) {
            if (smartSearch.getAge() == 0) {
                smartSearchUpdated.setAge(smartSearch.getAge());
            }
            smartSearchUpdated.setBudget((int) cart.getGrandTotal());
            smartSearchUpdated.setConsumer(smartSearch.getConsumer());
            smartSearchUpdated.setGender(smartSearch.getGender());
            smartSearchUpdated.setRelationship(smartSearch.getRelationship());
            String s1 = smartSearchUpdated.getSmartSearchInput() + " " + smartSearch.getSmartSearchInput();
            smartSearchUpdated.setSmartSearchInput(s1);
            smartSearchDao.addSearchInput(smartSearchUpdated);
        }
    }

    @Override
    public SmartSearch createSmartSearch(Customer customer) {
        return smartSearchDao.createSmartSearch(customer);
    }

    @Override
    public void saveSmartSearch(SmartSearch smartSearch) {
        smartSearchDao.saveSmartSearch(smartSearch);
    }

    @Override
    public List<SmartSearch> getSmartSearch() {
        return smartSearchDao.getSmartSearch();
    }

    @Override
    public List<SmartSearch> getSmartSearch(int cartId, int customerId) {
        return smartSearchDao.getSmartSearch(cartId, customerId);
    }

    @Override
    public SmartSearch getSmartSearchById(int id) {
        return smartSearchDao.getSmartSearchById(id);
    }

    @Override
    public SmartSearch clearSmartSearch(SmartSearch smartSearch) {
        smartSearch.setRelationship("");
        smartSearch.setBudget(0);
        smartSearch.setSmartSearchInput("");
        smartSearch.setAge(0);
        smartSearch.setConsumer("");
        smartSearch.setGender("");
        int searchId = smartSearch.getSearchId();
        smartSearchDao.clearSmartItems(searchId);
        return smartSearch;
    }
}