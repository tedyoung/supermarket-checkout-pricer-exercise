package dev.ted.supermarket.application;

import org.junit.jupiter.api.Test;

import static dev.ted.supermarket.application.ProductPricer.TOOTHBRUSH_UPC;
import static org.assertj.core.api.Assertions.*;

public class SpecialDealsCartTest {

    @Test
    public void twoToothbrushesThenCartTotalPriceIsTwoDollars() throws Exception {
        CartService cartService = new CartService();

        cartService.addProduct(TOOTHBRUSH_UPC);
        cartService.addProduct(TOOTHBRUSH_UPC);

        assertThat(cartService.total())
                .isEqualTo("2");
    }

}



