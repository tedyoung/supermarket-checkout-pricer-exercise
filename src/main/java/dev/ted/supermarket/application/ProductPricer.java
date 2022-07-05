package dev.ted.supermarket.application;

import java.math.BigDecimal;

public interface ProductPricer {
    BigDecimal priceFor(String upc);
}
