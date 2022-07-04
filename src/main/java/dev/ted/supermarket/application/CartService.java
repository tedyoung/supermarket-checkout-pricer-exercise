package dev.ted.supermarket.application;

import java.math.BigDecimal;

public class CartService {

    private final ProductPricer productPricer;

    private BigDecimal total = BigDecimal.ZERO;
    private boolean isEmpty = true;

    public CartService(ProductPricer productPricer) {
        this.productPricer = productPricer;
    }

    public BigDecimal total() {
        return total;
    }

    public void addProduct(String upc) {
        total = total.add(productPricer.priceFor(upc));
        isEmpty = false;
    }

    public Receipt finalizeOrder() {
        Receipt receipt = new Receipt(total);
        total = BigDecimal.ZERO;
        isEmpty = true;
        return receipt;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}
