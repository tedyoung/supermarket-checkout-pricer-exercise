package dev.ted.supermarket.application;

import org.junit.jupiter.api.Test;

import static dev.ted.supermarket.application.ProductPricer.TOOTHBRUSH_UPC;
import static org.assertj.core.api.Assertions.*;

public class PlaceOrderTest {

    @Test
    public void cartWithOneProductFinalizeOrderThenEmptiesCart() throws Exception {
        CartService cartService = new CartService();
        cartService.addProduct(TOOTHBRUSH_UPC);

        cartService.finalizeOrder();

        assertThat(cartService.total())
                .isZero();
        assertThat(cartService.isEmpty())
                .isTrue();
    }

    @Test
    public void cartWithOneProductFinalizeOrderReturnsReceipt() throws Exception {
        CartService cartService = new CartService();
        cartService.addProduct(TOOTHBRUSH_UPC);

        Receipt receipt = cartService.finalizeOrder();

        assertThat(receipt.total())
                .isEqualTo("1");
    }

}



