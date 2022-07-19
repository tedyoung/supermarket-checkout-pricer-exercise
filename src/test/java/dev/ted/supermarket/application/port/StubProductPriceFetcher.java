package dev.ted.supermarket.application.port;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class StubProductPriceFetcher implements ProductPriceFetcher {

    private final Map<String, BigDecimal> productToPrice = new HashMap<>();

    public StubProductPriceFetcher() {
    }

    public StubProductPriceFetcher(String upc, BigDecimal price,
                                   String upc2, BigDecimal price2) {
        productToPrice.put(upc, price);
        productToPrice.put(upc2, price2);
    }

    public StubProductPriceFetcher(String upc, BigDecimal price) {
        productToPrice.put(upc, price);
    }

    @Override
    public BigDecimal priceFor(String upc) {
        if (productToPrice.containsKey(upc)) {
            return productToPrice.get(upc);
        }
        throw new ProductNotFound(upc);
    }
}