package dev.ted.supermarket.application;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductPricerStub implements ProductPricer {
    static final int TOOTHBRUSH_PRICE = 1;
    static final int TOOTHPASTE_PRICE = 3;
    static final String TOOTHBRUSH_UPC = "0123";
    static final String TOOTHPASTE_UPC = "9456";

    private final Map<String, BigDecimal> productToPrice;

    public ProductPricerStub() {
        productToPrice = new HashMap<>();
        productToPrice.put(TOOTHPASTE_UPC, BigDecimal.valueOf(TOOTHPASTE_PRICE));
        productToPrice.put(TOOTHBRUSH_UPC, BigDecimal.valueOf(TOOTHBRUSH_PRICE));
    }

    @Override public BigDecimal priceFor(String upc) {
        if (productToPrice.containsKey(upc)) {
            return productToPrice.get(upc);
        }
        return BigDecimal.ZERO;
    }
}