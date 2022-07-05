package dev.ted.supermarket.application;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class PlaceOrderTest {

    private static final String TOOTHBRUSH_UPC = "0123";

    @Test
    public void cartWithOneProductFinalizeOrderThenEmptiesCart() throws Exception {
        ProductPricerStub productPricer = new ProductPricerStub(
                TOOTHBRUSH_UPC, BigDecimal.valueOf(1));
        CartService cartService = new CartService(productPricer);
        cartService.addProduct(TOOTHBRUSH_UPC);

        cartService.finalizeOrder();

        assertThat(cartService.total())
                .isZero();
        assertThat(cartService.isEmpty())
                .isTrue();
    }

    @Test
    public void cartWithNoProductsFinalizeOrderThrowsException() throws Exception {
        ProductPricerStub productPricer = new ProductPricerStub();
        CartService cartService = new CartService(productPricer);

        assertThatThrownBy(cartService::finalizeOrder)
                .isInstanceOf(NoProductsInCartException.class);
    }

    @Test
    public void cartWithOneProductFinalizeOrderReturnsReceipt() throws Exception {
        ProductPricerStub productPricer = new ProductPricerStub(
                TOOTHBRUSH_UPC, BigDecimal.valueOf(1));
        CartService cartService = new CartService(productPricer);
        cartService.addProduct(TOOTHBRUSH_UPC);

        Receipt receipt = cartService.finalizeOrder();

        assertThat(receipt.total())
                .isEqualTo("1");
        assertThat(receipt.products())
                .containsExactly(TOOTHBRUSH_UPC);
    }

}



