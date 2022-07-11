package dev.ted.supermarket.application;

import dev.ted.supermarket.application.port.ProductPriceFetcher;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductPriceFetcherStub implements ProductPriceFetcher {

    private final Map<String, BigDecimal> productToPrice = new HashMap<>();

    public ProductPriceFetcherStub() {
    }

    public ProductPriceFetcherStub(String upc, BigDecimal price,
                                   String upc2, BigDecimal price2) {
        productToPrice.put(upc, price);
        productToPrice.put(upc2, price2);
    }

    public ProductPriceFetcherStub(String upc, BigDecimal price) {
        productToPrice.put(upc, price);
    }

    @Override public BigDecimal priceFor(String upc) {
        if (productToPrice.containsKey(upc)) {
            return productToPrice.get(upc);
        }
        return BigDecimal.ZERO;
    }
}