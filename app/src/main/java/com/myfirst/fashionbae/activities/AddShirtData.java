package com.myfirst.fashionbae.activities;

public class AddShirtData {

    String brandName, price, size, imageUrl;

    public AddShirtData() {
    }
    public AddShirtData(String brandName, String price, String size, String imageUrl) {
        this.brandName = brandName;
        this.price = price;
        this.size = size;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
