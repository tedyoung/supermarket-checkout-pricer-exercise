package dev.ted.supermarket.application;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AddProductToCartTest {

    private static final String TOOTHBRUSH_UPC = "0123";
    private static final String TOOTHPASTE_UPC = "9456";

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
        cartService.addProduct(TOOTHBRUSH_UPC);

        // how do we know it was added: cart total == 1
        assertThat(cartService.total())
                .isEqualTo(1);
    }

    @Test
    public void twoToothbrushesThenCartTotalPriceIsTwoDollars() throws Exception {
        CartService cartService = new CartService();

        cartService.addProduct(TOOTHBRUSH_UPC);
        cartService.addProduct(TOOTHBRUSH_UPC);

        assertThat(cartService.total())
                .isEqualTo(2);
    }

    @Test
    public void addToothpasteThenCartTotalPriceIsThreeDollars() throws Exception {
        CartService cartService = new CartService();

        cartService.addProduct(TOOTHPASTE_UPC);

        assertThat(cartService.total())
                .isEqualTo(3);
    }

}

