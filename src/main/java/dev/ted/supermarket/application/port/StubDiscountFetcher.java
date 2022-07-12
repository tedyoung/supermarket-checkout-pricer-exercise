package dev.ted.supermarket.application.port;

import dev.ted.supermarket.domain.DiscountRule;

public class StubDiscountFetcher implements DiscountFetcher {

    @Override
    public DiscountRule discountRuleFor(String upc) {
        if (upc.equals("0987")) {
            return DiscountRule.TEN_PERCENT_OFF;
        }
        return DiscountRule.NONE;
    }
}