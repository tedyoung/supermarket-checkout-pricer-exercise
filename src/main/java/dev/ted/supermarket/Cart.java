package dev.ted.supermarket;

public class Cart {

    private int productPrice = 0;

    public int totalPrice() {
        return productPrice;
    }

    public void add(String productName, int productPrice) {
        this.productPrice = productPrice;
    }
}
