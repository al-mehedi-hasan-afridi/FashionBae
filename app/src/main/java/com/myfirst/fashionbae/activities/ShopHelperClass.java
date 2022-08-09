package com.myfirst.fashionbae.activities;

public class ShopHelperClass {

    String shopName,email,password;

    public ShopHelperClass() {
    }

    public ShopHelperClass(String shopName, String email, String password) {
        this.shopName = shopName;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
