package dev.ted.supermarket.application;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductPricerStub implements ProductPricer {

    private final Map<String, BigDecimal> productToPrice = new HashMap<>();

    public ProductPricerStub() {
    }

    public ProductPricerStub(String upc, BigDecimal price,
                             String upc2, BigDecimal price2) {
        productToPrice.put(upc, price);
        productToPrice.put(upc2, price2);
    }

    public ProductPricerStub(String upc, BigDecimal price) {
        productToPrice.put(upc, price);
    }

    @Override public BigDecimal priceFor(String upc) {
        if (productToPrice.containsKey(upc)) {
            return productToPrice.get(upc);
        }
        return BigDecimal.ZERO;
    }
}