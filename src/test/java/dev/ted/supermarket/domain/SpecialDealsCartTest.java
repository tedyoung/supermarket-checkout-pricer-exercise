package dev.ted.supermarket.domain;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class SpecialDealsCartTest {

    @Test
    public void twoSameItemsThenSecondIsDiscountedHalfOff() throws Exception {
        Cart cart = new Cart();

        cart.add("0123", BigDecimal.ONE);
        cart.add("0123", BigDecimal.ONE);

        assertThat(cart.total())
                .isEqualTo("1.5");
    }

    @Test
    @Disabled
    public void tenPercentDiscountOnCertainItem() throws Exception {

    }

}



