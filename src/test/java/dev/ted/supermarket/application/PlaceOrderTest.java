package dev.ted.supermarket.application;

import org.junit.jupiter.api.Test;

import static dev.ted.supermarket.application.ProductPricer.TOOTHBRUSH_UPC;
import static org.assertj.core.api.Assertions.*;

public class PlaceOrderTest {

    @Test
    public void cartWithOneProductPlaceOrderThenEmptiesCart() throws Exception {
        CartService cartService = new CartService();
        cartService.addProduct(TOOTHBRUSH_UPC);

        cartService.finalizeOrder();

        assertThat(cartService.total())
                .isZero();
        assertThat(cartService.isEmpty())
                .isTrue();
    }

}



