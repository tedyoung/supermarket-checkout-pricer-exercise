package dev.ted.supermarket.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class SpecialDealsCartTest {

    private static final String TEN_PERCENT_DISCOUNTED_UPC = "0987";

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

        cart.add(new Product(TEN_PERCENT_DISCOUNTED_UPC, BigDecimal.TEN));

        assertThat(cart.total())
                .isEqualByComparingTo(BigDecimal.valueOf(9));
    }

    @Test
    public void twoItemsThatHaveTenPercentDiscountOnlyHalfOffDiscountApplies() throws Exception {
        Cart cart = new Cart();

        cart.add(new Product(TEN_PERCENT_DISCOUNTED_UPC, BigDecimal.TEN));
        cart.add(new Product(TEN_PERCENT_DISCOUNTED_UPC, BigDecimal.TEN));

        assertThat(cart.total())
                .isEqualByComparingTo("15");
    }

}



