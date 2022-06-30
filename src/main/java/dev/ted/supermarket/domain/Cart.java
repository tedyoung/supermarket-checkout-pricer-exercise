package dev.ted.supermarket.domain;

public class Cart {

    private String productName;
    private int totalPrice = 0;

    public int totalPrice() {
        return totalPrice;
    }

    public void add(Product product) {
        this.productName = product.productName();
        this.totalPrice += product.productPrice();
    }

    public String productName() {
        return productName;
    }


}
