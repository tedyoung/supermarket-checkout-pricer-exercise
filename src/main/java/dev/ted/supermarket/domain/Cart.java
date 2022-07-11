package dev.ted.supermarket.domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<String> products = new ArrayList<String>();

    @Deprecated // return Stream<String> instead
    public List<String> products() {
        return List.copyOf(products);
    }

    public boolean add(String upc) {
        return products.add(upc);
    }
}