package dev.ted.supermarket.application;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class SpecialDealsCartTest {

    @Test
    @Disabled
    public void twoSameItemsThenSecondIsDiscountedHalfOff() throws Exception {
        CartService cartService = new CartService(new ProductPriceFetcherStub("9456", BigDecimal.valueOf(3), "0123", BigDecimal.valueOf(1)));

        cartService.addProduct("0123");
        cartService.addProduct("0123");

        assertThat(cartService.total())
                .isEqualTo("1.5");
    }

}



