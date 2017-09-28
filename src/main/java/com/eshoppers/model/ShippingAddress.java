package com.eshoppers.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class ShippingAddress implements Serializable {

    private static final long serialVersionUID = 1353190285989852315L;

    @Id
    @GeneratedValue
    private int shippingAddressId;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private String country;

    private String pinCode;

    @OneToOne
    private Customer customer;

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String streetName) {
        this.addressLine1 = streetName;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String apartmentNumber) {
        this.addressLine2 = apartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String zipCode) {
        this.pinCode = zipCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return addressLine1 + ",<br>" + addressLine2 + "<br>" + city + ". " + state + ".<br>" + country + ".-" + pinCode;
    }
}
