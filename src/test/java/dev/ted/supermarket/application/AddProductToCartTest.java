package dev.ted.supermarket.application;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class AddProductToCartTest {

    @Test
    public void cartTotalPriceStartsAtZeroAndIsEmpty() throws Exception {
        ProductPricerStub productPricer = new ProductPricerStub(
                "9456", BigDecimal.valueOf(3),
                "0123", BigDecimal.valueOf(1));
        CartService cartService = new CartService(productPricer);

        assertThat(cartService.total())
                .isZero();
        assertThat(cartService.isEmpty())
                .isTrue();
    }

    @Test
    public void addToothbrushThenCartTotalPriceIsOneDollar() throws Exception {
        ProductPricerStub productPricer = new ProductPricerStub(
                "9456", BigDecimal.valueOf(3),
                "0123", BigDecimal.valueOf(1));
        CartService cartService = new CartService(productPricer);

        cartService.addProduct("0123");

        assertThat(cartService.total())
                .isEqualTo("1");

        assertThat(cartService.isEmpty())
                .isFalse();
    }

    @Test
    public void twoItemsThenCartTotalPriceIsSumOfProductPrices() throws Exception {
        CartService cartService = new CartService(new ProductPricerStub("9456", BigDecimal.valueOf(3), "0123", BigDecimal.valueOf(1)));

        cartService.addProduct("0123");
        cartService.addProduct("9456");

        assertThat(cartService.total())
                .isEqualTo(BigDecimal.valueOf(1 + 3)); // evident data
    }

    @Test
    public void addToothpasteThenCartTotalPriceIsThreeDollars() throws Exception {
        CartService cartService = new CartService(new ProductPricerStub("9456", BigDecimal.valueOf(3), "0123", BigDecimal.valueOf(1)));

        cartService.addProduct("9456");

        assertThat(cartService.total())
                .isEqualTo("3");
    }

}

