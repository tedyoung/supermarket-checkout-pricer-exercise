package dev.ted.supermarket.application.port;

import java.math.BigDecimal;

public interface CartNotifier {
    void productAdded(String upc, BigDecimal productPrice);
}
