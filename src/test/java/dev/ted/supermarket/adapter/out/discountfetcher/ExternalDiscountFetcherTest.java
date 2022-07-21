package dev.ted.supermarket.adapter.out.discountfetcher;

import dev.ted.supermarket.application.port.DiscountFetcher;
import dev.ted.supermarket.domain.DiscountRule;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@Tag("manual")
class ExternalDiscountFetcherTest {

    @Test
    public void fetchReturnsNoneDiscountRule() throws Exception {
        DiscountFetcher discountFetcher = new ExternalDiscountFetcher();

        DiscountRule discountRule = discountFetcher.discountRuleFor("01239");

        assertThat(discountRule)
                .isEqualByComparingTo(DiscountRule.TEN_PERCENT_OFF);
    }

}