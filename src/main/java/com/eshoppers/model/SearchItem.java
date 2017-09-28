package com.eshoppers.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class SearchItem implements Serializable {

    private static final long serialVersionUID = -3581311724946775333L;

    @Id
    @GeneratedValue
    private int searchItemId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "searchId")
    @JsonIgnore
    private SmartSearch smartSearch;

    public int getSearchItemId() {
        return searchItemId;
    }

    public void setSearchItemId(int searchItemId) {
        this.searchItemId = searchItemId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public SmartSearch getSmartSearch() {
        return smartSearch;
    }

    public void setSmartSearch(SmartSearch smartSearch) {
        this.smartSearch = smartSearch;
    }
}
