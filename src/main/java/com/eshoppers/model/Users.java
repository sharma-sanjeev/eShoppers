package com.eshoppers.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Users implements Serializable {

    private static final long serialVersionUID = 3649600892891080252L;

    @Id
    @GeneratedValue
    private int userId;

    private String username;

    private String password;

    private boolean enabled;

    private int customerId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnable() {
        return enabled;
    }

    public void setEnable(boolean enabled) {
        this.enabled = enabled;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}