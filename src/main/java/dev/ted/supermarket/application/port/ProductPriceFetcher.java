package dev.ted.supermarket.application.port;

import java.math.BigDecimal;

public interface ProductPriceFetcher {
    BigDecimal priceFor(String upc);
}
