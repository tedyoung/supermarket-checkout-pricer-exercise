package dev.ted.supermarket.application;

import dev.ted.supermarket.domain.Cart;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class SpecialDealsCartTest {

    @Test
    @Disabled
    public void twoSameItemsThenSecondIsDiscountedHalfOff() throws Exception {
        Cart cart = new Cart();

        cart.add("0123", BigDecimal.ONE);
        cart.add("0123", BigDecimal.ONE);

        assertThat(cart.total())
                .isEqualTo("1.5");
    }

}



