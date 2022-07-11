package dev.ted.supermarket.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// ideas for naming:
// Order, Bag, Scale
public class Cart {
    private final List<String> products = new ArrayList<>();
    private BigDecimal total = BigDecimal.ZERO;

    public boolean add(String upc, BigDecimal productPrice) {
        total = total.add(productPrice);
        discountForDuplicateItem(upc, productPrice);
        return products.add(upc);
    }

    private void discountForDuplicateItem(String upc, BigDecimal productPrice) {
        if (products.contains(upc)) {
            total = total.subtract(productPrice.divide(BigDecimal.valueOf(2)));
        }
    }

    public BigDecimal total() {
        return total;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public Receipt receipt() {
        return new Receipt(total, List.copyOf(products));
    }
}