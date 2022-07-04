package dev.ted.supermarket.application;

public class CartService {

    private int total = 0;

    public int total() {
        return total;
    }

    public void addProduct(String upc) {
        total = 1;
    }
}
