package com.myfirst.fashionbae.activities;

public class FootWearData {
    String brandName,price,size;

    public FootWearData() {

    }

    public FootWearData(String brandName, String price, String size) {
        this.brandName = brandName;
        this.price = price;
        this.size = size;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBrandName() {

        return brandName;
    }
    public String getPrice() {

        return price;
    }

    public String getSize() {

        return size;
    }

}


