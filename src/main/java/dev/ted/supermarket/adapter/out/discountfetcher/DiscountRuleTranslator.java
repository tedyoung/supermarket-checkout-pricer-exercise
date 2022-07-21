package dev.ted.supermarket.adapter.out.discountfetcher;

import dev.ted.supermarket.domain.DiscountRule;

public class DiscountRuleTranslator {

    @SuppressWarnings("SwitchStatementWithTooFewBranches")
    static DiscountRule toRule(String remoteDiscountRuleCode) {
        return switch (remoteDiscountRuleCode) {
            case "t" -> DiscountRule.TEN_PERCENT_OFF;
            default -> DiscountRule.NONE;
        };
    }

}
