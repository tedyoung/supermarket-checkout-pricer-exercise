package dev.ted.supermarket.application.port;

import java.math.BigDecimal;

public interface ProductPricer {
    BigDecimal priceFor(String upc);
}
