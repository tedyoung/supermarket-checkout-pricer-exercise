package dev.ted.supermarket.application.port;

import dev.ted.supermarket.domain.DiscountRule;

public class StubDiscountFetcher implements DiscountFetcher {

    private String discountedUpc;
    private DiscountRule discountRule;

    public StubDiscountFetcher(String discountedUpc, DiscountRule discountRule) {
        this.discountedUpc = discountedUpc;
        this.discountRule = discountRule;
    }

    @Override
    public DiscountRule discountRuleFor(String upc) {
        if (upc.equals(discountedUpc)) {
            return discountRule;
        }
        return DiscountRule.NONE;
    }
}