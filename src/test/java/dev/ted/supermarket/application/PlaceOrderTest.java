package dev.ted.supermarket.application;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class PlaceOrderTest {

    @Test
    public void cartWithOneProductFinalizeOrderThenEmptiesCart() throws Exception {
        ProductPricerStub productPricer = new ProductPricerStub(
                "0123", BigDecimal.valueOf(1));
        CartService cartService = new CartService(productPricer);
        cartService.addProduct("0123");

        cartService.finalizeOrder();

        assertThat(cartService.total())
                .isZero();
        assertThat(cartService.isEmpty())
                .isTrue();
    }

    @Test
    public void cartWithOneProductFinalizeOrderReturnsReceipt() throws Exception {
        ProductPricerStub productPricer = new ProductPricerStub(
                "0123", BigDecimal.valueOf(1));
        CartService cartService = new CartService(productPricer);
        cartService.addProduct("0123");

        Receipt receipt = cartService.finalizeOrder();

        assertThat(receipt.total())
                .isEqualTo("1");
    }

}



