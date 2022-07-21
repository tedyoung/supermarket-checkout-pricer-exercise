package dev.ted.supermarket.application;

import dev.ted.supermarket.application.port.CartNotifier;
import dev.ted.supermarket.application.port.StubDiscountFetcher;
import dev.ted.supermarket.application.port.StubProductPriceFetcher;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

class CartServiceNotifierTest {

    private static final String TOOTHPASTE_UPC = "033200000167";

    @Test
    public void whenValidProductAddedThenCheckoutDisplayNotified() throws Exception {
        CartNotifier cartNotifierSpy = spy(CartNotifier.class);
        StubProductPriceFetcher productPricer =
                new StubProductPriceFetcher(TOOTHPASTE_UPC,
                                            new BigDecimal("3.01"));
        CartService cartService =
                new CartService(productPricer,
                                StubDiscountFetcher.noDiscounts(),
                                cartNotifierSpy);

        cartService.addProduct(TOOTHPASTE_UPC);

        verify(cartNotifierSpy).productAdded(TOOTHPASTE_UPC,
                                             new BigDecimal("3.01"));
    }

}