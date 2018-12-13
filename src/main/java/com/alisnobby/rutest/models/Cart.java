package com.alisnobby.rutest.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cart {

    private Map<Product, LineItem> lineitemsMap;

    public Cart() {
        lineitemsMap = new HashMap<Product, LineItem>();
    }

    public Cart(Map<Product, LineItem> lineitemsMap) {
        this.lineitemsMap = lineitemsMap;
    }

    public Map<Product, LineItem> getLineitemsMap() {
        return lineitemsMap;
    }

    public void setLineitemsMap(Map<Product, LineItem> lineitemsMap) {
        this.lineitemsMap = lineitemsMap;
    }

    public Boolean isEmpty(){
        if(this.lineitemsMap == null || this.lineitemsMap.isEmpty()) {
            return true;
        }
        return false;

    }

    public void addProduct(Product product) {
        if(this.lineitemsMap.containsKey(product)){
            LineItem lineItem = this.lineitemsMap.get(product);
            lineItem.incrementProduct();
            this.lineitemsMap.put(product, lineItem);
        }
        else {
            LineItem lineItem = new LineItem(product);
            this.lineitemsMap.put(product, lineItem);
        }

        System.out.println(product.getProductName() + "was added to the cart");
    }

    public void removeProduct(Product product){

        if(this.lineitemsMap.containsKey(product)){
            LineItem lineItem = this.lineitemsMap.get(product);
            lineItem.decrementProduct();
            if(lineItem.getQuantity()==0){
                this.lineitemsMap.remove(product);
            } else {
                this.lineitemsMap.put(product, lineItem);
            }
        }
        else {
            System.out.println("Cart doesn't contain the product asked to be removed");
        }

    }

    public Double getRegularPriceforProduct(Product product){
        if(this.lineitemsMap.containsKey(product)) {
            LineItem lineItem = this.lineitemsMap.get(product);
            return lineItem.getTotalRegularPrice();
        } else {
            return 0.0;
        }
    }

    public Double getDiscountedPriceforProduct(Product product){
        if(this.lineitemsMap.containsKey(product)) {
            LineItem lineItem = this.lineitemsMap.get(product);
            return lineItem.getTotalDiscountedPrice();
        } else {
            return 0.0;
        }
    }

    public Double getTotalRegularPriceforProduct(){
        if(this.lineitemsMap.isEmpty()) {
            return 0.0;
        }
        Double totalRegPrice =0.0;

        Set<Map.Entry<Product, LineItem>> lineItemsSet = this.lineitemsMap.entrySet();

        for(Map.Entry<Product, LineItem> eachLineItem: lineItemsSet){
            totalRegPrice += eachLineItem.getValue().getTotalRegularPrice();
        }
        return totalRegPrice;
    }

    public Double getTotalDiscountedPriceforProduct(){
        if(this.lineitemsMap.isEmpty()) {
            return 0.0;
        }
        Double totalDiscPrice =0.0;

        Set<Map.Entry<Product, LineItem>> lineItemsSet = this.lineitemsMap.entrySet();

        for(Map.Entry<Product, LineItem> eachLineItem: lineItemsSet){
            totalDiscPrice += eachLineItem.getValue().getTotalDiscountedPrice();
        }
        return totalDiscPrice;
    }

    public void showCartDetails(){

        if(this.isEmpty()) {
            System.out.println("Empty cart");
        }
        Set<Map.Entry<Product, LineItem>> lineItemsSet = this.lineitemsMap.entrySet();

        for(Map.Entry<Product, LineItem> eachLineItem: lineItemsSet){
            System.out.println("Line item for product " + eachLineItem.getKey().getProductName() +
                    "Quantity =" + eachLineItem.getValue().getQuantity() +
                    "Total regular price  =" + eachLineItem.getValue().getTotalRegularPrice() +
                    "Total Discounted price  =" + eachLineItem.getValue().getTotalDiscountedPrice());

        }


    }


}
