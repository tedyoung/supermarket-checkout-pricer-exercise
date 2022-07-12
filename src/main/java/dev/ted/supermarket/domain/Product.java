package dev.ted.supermarket.domain;

import java.math.BigDecimal;

// VALUE OBJECT
public record Product(String upc,
                      BigDecimal productPrice,
                      DiscountRule discountRule) {

    public Product(String upc, BigDecimal productPrice) {
        this(upc, productPrice, DiscountRule.NONE);
    }

}