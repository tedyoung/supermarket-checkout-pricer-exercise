package dev.ted.supermarket.application;

import java.math.BigDecimal;

public class CartService {

    private final ProductPricer productPricer = new ProductPricer();

    private BigDecimal total = BigDecimal.ZERO;
    private boolean isEmpty = true;

    public BigDecimal total() {
        return total;
    }

    public void addProduct(String upc) {
        total = total.add(productPricer.priceFor(upc));
        isEmpty = false;
    }

    public void finalizeOrder() {
        total = BigDecimal.ZERO;
        isEmpty = true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}
