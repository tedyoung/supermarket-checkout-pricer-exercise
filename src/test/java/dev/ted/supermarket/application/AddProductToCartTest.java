package dev.ted.supermarket.application;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class AddProductToCartTest {

    private static final String TOOTHBRUSH_UPC = "0123";
    private static final String TOOTHPASTE_UPC = "9456";

    @Test
    public void cartTotalPriceStartsAtZeroAndIsEmpty() throws Exception {
        ProductPriceFetcherStub productPricer = new ProductPriceFetcherStub();
        CartService cartService = new CartService(productPricer);

        assertThat(cartService.total())
                .isZero();
        assertThat(cartService.isEmpty())
                .isTrue();
    }

    @Test
    public void addToothbrushThenCartTotalPriceIsOneDollar() throws Exception {
        ProductPriceFetcherStub productPricer = new ProductPriceFetcherStub(
                TOOTHBRUSH_UPC, BigDecimal.valueOf(1));
        CartService cartService = new CartService(productPricer);

        cartService.addProduct(TOOTHBRUSH_UPC);

        assertThat(cartService.total())
                .isEqualTo("1");

        assertThat(cartService.isEmpty())
                .isFalse();
    }

    @Test
    public void twoItemsThenCartTotalPriceIsSumOfProductPrices() throws Exception {
        ProductPriceFetcherStub productPricer = new ProductPriceFetcherStub(
                TOOTHBRUSH_UPC, BigDecimal.valueOf(1),
                TOOTHPASTE_UPC, BigDecimal.valueOf(3));
        CartService cartService = new CartService(productPricer);

        cartService.addProduct(TOOTHBRUSH_UPC);
        cartService.addProduct(TOOTHPASTE_UPC);

        assertThat(cartService.total())
                .isEqualTo(BigDecimal.valueOf(1 + 3)); // evident data
    }

    @Test
    public void addToothpasteThenCartTotalPriceIsThreeDollars() throws Exception {
        ProductPriceFetcherStub productPricer = new ProductPriceFetcherStub(
                TOOTHPASTE_UPC, BigDecimal.valueOf(3));
        CartService cartService = new CartService(productPricer);

        cartService.addProduct(TOOTHPASTE_UPC);

        assertThat(cartService.total())
                .isEqualTo("3");
    }

}

