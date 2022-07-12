package dev.ted.supermarket.application.port;

import dev.ted.supermarket.domain.DiscountRule;

public interface DiscountFetcher {
    DiscountRule discountRuleFor(String upc);
}
