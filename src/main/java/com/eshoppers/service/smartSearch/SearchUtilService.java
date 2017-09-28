package com.eshoppers.service.smartSearch;

import com.eshoppers.model.Product;
import com.eshoppers.model.SmartSearch;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SearchUtilService {

    String findAmazonCategory(String stringList);

    void amazonProducts(String smartSearchInput, HttpServletRequest request);

    String cleanString(String string);

    List<String> splitString(String strings);

    List<Product> productNameSearch(String smartSearchInput);

    void brandNameSearch(SmartSearch smartSearch);

}