package com.eshoppers.service.smartSearch;

import com.eshoppers.model.SmartSearch;

import javax.servlet.http.HttpServletRequest;

public interface SmartPageOneService {

    void smartSearchInput(SmartSearch smartSearch, HttpServletRequest request);

}
