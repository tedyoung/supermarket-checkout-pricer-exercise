package dev.ted.supermarket.application;

import dev.ted.supermarket.domain.DiscountRule;

public class StubDiscountFetcher {
    public StubDiscountFetcher() {
    }

    DiscountRule discountRuleFor(String upc) {
        if (upc.equals("0987")) {
            return DiscountRule.TEN_PERCENT_OFF;
        }
        return DiscountRule.NONE;
    }
}