package com.eshoppers.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class SmartSearch implements Serializable {

    private static final long serialVersionUID = -1904482594624695895L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int searchId;

    private String smartSearchInput;

    private int age;

    private String consumer;

    private String gender;

    private String relationship;

    @OneToOne
    @JoinColumn(name = "customerId")
    @JsonIgnore
    private Customer customer;

    private int budget;

    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    @OneToMany(mappedBy = "smartSearch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SearchItem> searchItems;

    public SmartSearch() {
        this.smartSearchInput = "";
        this.age = 0;
        this.consumer = "";
        this.gender = "";
        this.relationship = "";
        this.budget = 0;
    }

    public int getSearchId() {
        return searchId;
    }

    public void setSearchId(int searchId) {
        this.searchId = searchId;
    }

    public String getSmartSearchInput() {
        return smartSearchInput;
    }

    public void setSmartSearchInput(String smartSearchInput) {
        this.smartSearchInput = smartSearchInput;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int ageGroup) {
        this.age = ageGroup;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public List<SearchItem> getSearchItems() {
        return searchItems;
    }

    public void setSearchItems(List<SearchItem> searchItems) {
        this.searchItems = searchItems;
    }
}