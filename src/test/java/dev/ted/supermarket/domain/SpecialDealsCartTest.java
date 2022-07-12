package dev.ted.supermarket.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class SpecialDealsCartTest {

    private static final String TEN_PERCENT_DISCOUNTED_UPC = "0987";
    private static final Product PRODUCT_PRICED_AT_TEN_AND_TEN_PERCENT_OFF_DISCOUNT = new Product(
            TEN_PERCENT_DISCOUNTED_UPC,
            BigDecimal.TEN,
            DiscountRule.TEN_PERCENT_OFF);

    @Test
    public void twoSameItemsThenSecondIsDiscountedHalfOff() throws Exception {
        Cart cart = new Cart();

        cart.add(new Product("0123", BigDecimal.ONE));
        cart.add(new Product("0123", BigDecimal.ONE));

        assertThat(cart.total())
                .isEqualByComparingTo("1.5");
    }

    @Test
    public void threeSameItemsThenSecondAndThirdAreDiscountedHalfOff() throws Exception {
        Cart cart = new Cart();

        cart.add(new Product("0123", BigDecimal.ONE));
        cart.add(new Product("0123", BigDecimal.ONE));
        cart.add(new Product("0123", BigDecimal.ONE));

        assertThat(cart.total())
                .isEqualByComparingTo("2");
    }

    @Test
    public void tenPercentDiscountOnCertainItem() throws Exception {
        Cart cart = new Cart();

        cart.add(PRODUCT_PRICED_AT_TEN_AND_TEN_PERCENT_OFF_DISCOUNT);

        assertThat(cart.total())
                .isEqualByComparingTo("9");
    }

    @Test
    public void twoItemsThatHaveTenPercentDiscountOnlyHalfOffDiscountApplies() throws Exception {
        Cart cart = new Cart();

        cart.add(PRODUCT_PRICED_AT_TEN_AND_TEN_PERCENT_OFF_DISCOUNT);
        cart.add(PRODUCT_PRICED_AT_TEN_AND_TEN_PERCENT_OFF_DISCOUNT);

        assertThat(cart.total())
                .isEqualByComparingTo("15");
    }

}



