package dev.ted.supermarket.domain;

import dev.ted.supermarket.application.NoProductsInCartException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// ideas for naming:
// Order, Bag, Scale
public class Cart {
    private final List<String> products = new ArrayList<String>();
    private boolean isEmpty = true;
    private BigDecimal total = BigDecimal.ZERO;

    public boolean add(String upc, BigDecimal productPrice) {
        isEmpty = false;
        total = total.add(productPrice);
        if (products.contains(upc)) {
            total = total.subtract(productPrice.divide(BigDecimal.valueOf(2)));
        }
        return products.add(upc);
    }

    public BigDecimal total() {
        return total;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void requireCartNotEmpty() {
        if (isEmpty) {
            throw new NoProductsInCartException();
        }
    }

    public Receipt receipt() {
        return new Receipt(total, List.copyOf(products));
    }
}