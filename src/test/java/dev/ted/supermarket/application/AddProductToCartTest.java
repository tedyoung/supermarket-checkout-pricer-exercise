package dev.ted.supermarket.application;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AddProductToCartTest {

    @Test
    public void cartTotalStartsAtZero() throws Exception {
        CartService cartService = new CartService();

        int total = cartService.total();

        assertThat(total)
                .isZero();
    }

    public void addToothbrushThenCartTotalPriceIsOneDollar() throws Exception {
        // add product (toothbrush)
        // how do we know it was added?
    }
}
