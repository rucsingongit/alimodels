package com.alisnobby.rutest.models;

public class LineItem {

    private Product product;

    private Integer quantity;


    public LineItem() {
        this.product=null;
        this.quantity=0;
    }

    public LineItem(Product product) {
        this.product = product;
        this.quantity = 1;
    }

    public LineItem(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalRegularPrice() {
        return this.quantity * this.product.getRegPrice();
    }


    public Double getTotalDiscountedPrice() {
        return this.quantity * this.product.getDiscountedPrice();
    }


    public void incrementProduct() {
        this.quantity++;
    }

    public void decrementProduct() {
        this.quantity--;
    }
}

