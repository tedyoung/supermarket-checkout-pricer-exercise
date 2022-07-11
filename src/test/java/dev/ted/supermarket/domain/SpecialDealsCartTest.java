package dev.ted.supermarket.domain;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class SpecialDealsCartTest {

    private static final String TEN_PERCENT_DISCOUNTED_UPC = "0987";

    @Test
    public void twoSameItemsThenSecondIsDiscountedHalfOff() throws Exception {
        Cart cart = new Cart();

        cart.add("0123", BigDecimal.ONE);
        cart.add("0123", BigDecimal.ONE);

        assertThat(cart.total())
                .isEqualTo("1.5");
    }

    @Test
    public void tenPercentDiscountOnCertainItem() throws Exception {
        Cart cart = new Cart();

        cart.add(TEN_PERCENT_DISCOUNTED_UPC, BigDecimal.TEN);

        assertThat(cart.total())
                .isEqualByComparingTo(BigDecimal.valueOf(9));
    }

    @Test
    @Disabled
    public void twoItemsThatHaveTenPercentDiscountOnlyHalfOffDiscountApplies() throws Exception {
        Cart cart = new Cart();

        cart.add(TEN_PERCENT_DISCOUNTED_UPC, BigDecimal.TEN);
        cart.add(TEN_PERCENT_DISCOUNTED_UPC, BigDecimal.TEN);

        assertThat(cart.total())
                .isEqualTo("15");
    }

}



