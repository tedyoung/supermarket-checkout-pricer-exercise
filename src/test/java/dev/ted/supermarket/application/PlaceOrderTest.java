package dev.ted.supermarket.application;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class PlaceOrderTest {

    @Test
    public void cartWithOneProductFinalizeOrderThenEmptiesCart() throws Exception {
        CartService cartService = new CartService(new ProductPricerStub("9456", BigDecimal.valueOf(3), "0123", BigDecimal.valueOf(1)));
        cartService.addProduct("0123");

        cartService.finalizeOrder();

        assertThat(cartService.total())
                .isZero();
        assertThat(cartService.isEmpty())
                .isTrue();
    }

    @Test
    public void cartWithOneProductFinalizeOrderReturnsReceipt() throws Exception {
        CartService cartService = new CartService(new ProductPricerStub("9456", BigDecimal.valueOf(3), "0123", BigDecimal.valueOf(1)));
        cartService.addProduct("0123");

        Receipt receipt = cartService.finalizeOrder();

        assertThat(receipt.total())
                .isEqualTo("1");
    }

}



