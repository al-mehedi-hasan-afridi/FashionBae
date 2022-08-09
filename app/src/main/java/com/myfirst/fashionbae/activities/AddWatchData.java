package com.myfirst.fashionbae.activities;

public class AddWatchData {

    String brandName, price, imageUrl;

    public AddWatchData() {
    }

    public AddWatchData(String brandName, String price, String imageUrl) {
        this.brandName = brandName;
        this.price = price;
        this.imageUrl = imageUrl;

    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
