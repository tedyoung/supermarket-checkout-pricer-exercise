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

    @Deprecated // return Stream<String> instead
    public List<String> products() {
        return List.copyOf(products);
    }

    public boolean add(String upc, BigDecimal productPrice) {
        isEmpty = false;
        total = total.add(productPrice);
        return products.add(upc);
    }

    public void makeEmpty() {
        isEmpty = true;
        total = BigDecimal.ZERO;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void requireCartNotEmpty() {
        if (isEmpty) {
            throw new NoProductsInCartException();
        }
    }

    public BigDecimal total() {
        return total;
    }

    public Receipt receipt() {
        return new Receipt(total(), products());
    }
}