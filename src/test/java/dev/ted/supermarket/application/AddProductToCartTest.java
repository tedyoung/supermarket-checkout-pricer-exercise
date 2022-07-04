package dev.ted.supermarket.application;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AddProductToCartTest {

    @Test
    public void cartTotalPriceStartsAtZero() throws Exception {
        CartService cartService = new CartService();

        int total = cartService.total();

        assertThat(total)
                .isZero();
    }

    @Test
    public void addToothbrushThenCartTotalPriceIsOneDollar() throws Exception {
        CartService cartService = new CartService();

        // add product (toothbrush)
        cartService.addProduct("0123");

        // how do we know it was added: cart total == 1
        assertThat(cartService.total())
                .isEqualTo(1);
    }

    @Test
    public void twoToothbrushesThenCartTotalPriceIsTwoDollars() throws Exception {
        CartService cartService = new CartService();

        cartService.addProduct("0123");
        cartService.addProduct("0123");

        assertThat(cartService.total())
                .isEqualTo(2);
    }
}
