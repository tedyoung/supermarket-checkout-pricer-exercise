package dev.ted.supermarket.domain;

import java.util.stream.Stream;

public class Cart {

    private int totalPrice = 0;
    private Product product;

    public int totalPrice() {
        return totalPrice;
    }

    public void add(Product product) {
        this.totalPrice += product.productPrice();
        this.product = product;
    }

    public Stream<Product> contents() {
        return Stream.of(product);
    }

}
