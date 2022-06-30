package dev.ted.supermarket.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Cart {

    private int totalPrice = 0;
    private final List<Product> products = new ArrayList<>();

    public int totalPrice() {
        return totalPrice;
    }

    public void add(Product product) {
        this.totalPrice += product.productPrice();
        this.products.add(product);
    }

    public Stream<Product> contents() {
        return products.stream();
    }

}
