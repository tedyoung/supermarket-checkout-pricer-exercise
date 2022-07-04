package dev.ted.supermarket.application;

import java.math.BigDecimal;

public class CartService {

    private final ProductPricer productPricer = new ProductPricer();

    private BigDecimal total = BigDecimal.ZERO;

    public BigDecimal total() {
        return total;
    }

    public void addProduct(String upc) {
        total = total.add(productPricer.priceFor(upc));
    }

}
