package dev.ted.supermarket.application;

import java.math.BigDecimal;
import java.util.Collections;

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
        if (isEmpty) {
            throw new NoProductsInCartException();
        }
        Receipt receipt = new Receipt(total, Collections.emptyList());
        total = BigDecimal.ZERO;
        isEmpty = true;
        return receipt;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}
