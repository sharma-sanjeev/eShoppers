package com.eshoppers.service.impl.smartSearchImpl;

import com.eshoppers.model.Product;
import com.eshoppers.model.SearchItem;
import com.eshoppers.model.SmartSearch;
import com.eshoppers.service.AmazonService;
import com.eshoppers.service.ProductService;
import com.eshoppers.service.smartSearch.SearchItemService;
import com.eshoppers.service.smartSearch.SearchUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@Service
public class SearchUtilServiceImpl implements SearchUtilService {

    @Autowired
    private AmazonService amazonService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SearchItemService searchItemService;

    private String keyword;

    public String findAmazonCategory(String smartInput) {
        StringBuilder sb = new StringBuilder();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        Resource resource = context.getResource("classpath:amazon.properties");
        try {
            File file = resource.getFile();
            FileInputStream fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();

            List<String> smartSplit = splitString(smartInput);
            Enumeration enuKeys = properties.keys();
            while (enuKeys.hasMoreElements()) {
                String key = (String) enuKeys.nextElement();
                String value = properties.getProperty(key);
                List<String> valueSplit = splitString(value);

                for (String smartSplitString : smartSplit) {
                    for (String valueSplitString : valueSplit) {
                        if (cleanString(smartSplitString).equals(cleanString(valueSplitString))) {
                            sb.append(valueSplitString);
                            sb.append(" ");
                        }
                    }
                    this.setKeyword(sb.toString());
                    this.uniqueString();
                    if (sb.length() > 5) {
                        return key;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setKeyword(smartInput);
        return "All";
    }

    public void amazonProducts(String smartSearchInput, HttpServletRequest request) {

        String category = findAmazonCategory(smartSearchInput);
        String amazonKewords = amazonSearchString(smartSearchInput);
        List<Product> products = new ArrayList<>();
        try {
            products.addAll(amazonService.lookupStuff(amazonKewords, category, request));
            for (Product product : products) {
                productService.addProduct(product);
            }
        } catch (Exception e) {
            System.out.println("Problem with Amazon Service");
        }
    }

    public String cleanString(String string) {
        return string.replaceAll("[-+.^:,]", " ").toLowerCase();
    }

    public List<String> splitString(String strings) {
        List<String> list = new ArrayList<>();
        for (String string : strings.split(" ")) {
            if (string != null || string != "" || !string.isEmpty() && string.length() > 3) {
                String cleanString = cleanString(string);
                if (cleanString != " " && cleanString != null && cleanString.length() > 3) {
                    list.add(cleanString);
                }
            }
        }
        return list;
    }

    public String amazonSearchString(String searchInput) {
        List<String> filteredKeyword = splitString(searchInput);
        StringBuilder sb = new StringBuilder();
        int j = 3;
        if (filteredKeyword.size() < 3) {
            j = filteredKeyword.size();
        }
        for (int i = 0; i < j; i++) {
            sb.append(filteredKeyword.get(i));
            sb.append(" ");
        }
        return sb.toString();
    }

    public List<Product> productNameSearch(String smartSearchInput) {
        Set<Product> productNameSearch = new LinkedHashSet<>();
        for (String splittedSmartSearchInput : splitString(smartSearchInput)) {
            for (Product product : productService.getProductList()) {
                List<String> productNames = splitString(product.getProductName());
                List<String> productManufacturer = splitString(product.getProductManufacturer());
                List<String> productDescription = splitString(product.getProductDescription());
                productNames.addAll(productManufacturer);

                for (String productName : productNames) {
                    if (splittedSmartSearchInput.equals(productName))
                        productNameSearch.add(product);
                }
                for (String productDesc : productDescription) {
                    if (splittedSmartSearchInput.equals(productDesc)) {
                        productNameSearch.add(product);
                        break;
                    }
                }
            }
        }
        return new ArrayList<>(productNameSearch);
    }

    public void uniqueString() {
        List<String> strings = splitString(this.keyword);
        StringBuilder sb = new StringBuilder();
        Set<String> stringsSet = new HashSet<>();
        stringsSet.addAll(strings);
        for (String s : stringsSet) {
            sb.append(s).append(" ");
        }
        this.keyword = sb.toString();
    }

    @Override
    public void brandNameSearch(SmartSearch smartSearch) {
        String smartSearchInput = smartSearch.getSmartSearchInput();
        int i = smartSearch.getSearchId();
        List<SearchItem> searchItems = searchItemService.getSearchItemsById(i);
        List<String> splitInput = splitString(smartSearchInput);
        String brand = null;
        Flag:
        for (String splittedSmartSearchInput : splitInput) {
            for (SearchItem searchItem : searchItems) {
                String manufacturer = cleanString(searchItem.getProduct().getProductManufacturer());
                if (splittedSmartSearchInput.equals(manufacturer)) {
                    brand = manufacturer;
                    break Flag;
                }
            }
        }
        if (brand != null) {
            for (SearchItem searchItem : searchItems) {
                String manufacturer = cleanString(searchItem.getProduct().getProductManufacturer());
                if (!brand.equals(manufacturer) && searchItem != null) {
                    searchItemService.removeSearchItem(searchItem);
                }
            }
        }
    }


    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}