package com.alisnobby.rutest.models;

public class Product {

    private String productName;

    private Double regPrice;

    private Double discountedPrice;

    public Product() {
    }

    public Product(String productName) {
        this.productName = productName;
    }

    public Product(String productName, Double regPrice) {
        this.productName = productName;
        this.regPrice = regPrice;
    }

    public Product(String productName, Double regPrice, Double discountedPrice) {
        this.productName = productName;
        this.regPrice = regPrice;
        this.discountedPrice = discountedPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getRegPrice() {
        return regPrice;
    }

    public void setRegPrice(Double regPrice) {
        this.regPrice = regPrice;
    }

    public Double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}
