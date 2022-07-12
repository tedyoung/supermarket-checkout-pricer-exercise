package dev.ted.supermarket.application;

import dev.ted.supermarket.application.port.ProductPriceFetcherStub;
import dev.ted.supermarket.application.port.StubDiscountFetcher;
import dev.ted.supermarket.domain.Receipt;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class PlaceOrderTest {

    private static final String TOOTHBRUSH_UPC = "0123";
    private static final String TOOTHPASTE_UPC = "9456";

    @Test
    public void cartWithOneProductFinalizeOrderThenEmptiesCart() throws Exception {
        ProductPriceFetcherStub productPricer = new ProductPriceFetcherStub(
                TOOTHBRUSH_UPC, BigDecimal.valueOf(1));
        CartService cartService = new CartService(productPricer, StubDiscountFetcher.noDiscounts());
        cartService.addProduct(TOOTHBRUSH_UPC);

        cartService.finalizeOrder();

        assertThat(cartService.total())
                .isZero();
        assertThat(cartService.isEmpty())
                .isTrue();
    }

    @Test
    public void cartWithNoProductsFinalizeOrderThrowsException() throws Exception {
        ProductPriceFetcherStub productPricer = new ProductPriceFetcherStub();
        CartService cartService = new CartService(productPricer, StubDiscountFetcher.noDiscounts());

        assertThatThrownBy(cartService::finalizeOrder)
                .isInstanceOf(NoProductsInCartException.class);
    }

    @Test
    public void cartWithOneProductFinalizeOrderReturnsReceipt() throws Exception {
        ProductPriceFetcherStub productPricer = new ProductPriceFetcherStub(
                TOOTHBRUSH_UPC, BigDecimal.valueOf(1));
        CartService cartService = new CartService(productPricer, StubDiscountFetcher.noDiscounts());
        cartService.addProduct(TOOTHBRUSH_UPC);

        Receipt receipt = cartService.finalizeOrder();

        assertThat(receipt.total())
                .isEqualByComparingTo("1");
        assertThat(receipt.products())
                .containsExactly(TOOTHBRUSH_UPC);
    }

    @Test
    public void cartWithTwoProductsFinalizeOrderReturnsReceiptWithAllProducts() throws Exception {
        ProductPriceFetcherStub productPricer = new ProductPriceFetcherStub(
                TOOTHBRUSH_UPC, BigDecimal.valueOf(1),
                TOOTHPASTE_UPC, BigDecimal.valueOf(3));
        CartService cartService = new CartService(productPricer, StubDiscountFetcher.noDiscounts());
        cartService.addProduct(TOOTHBRUSH_UPC);
        cartService.addProduct(TOOTHPASTE_UPC);

        Receipt receipt = cartService.finalizeOrder();

        assertThat(receipt.total())
                .isEqualByComparingTo(BigDecimal.valueOf(1 + 3));
        assertThat(receipt.products())
                .containsExactly(TOOTHBRUSH_UPC,
                                 TOOTHPASTE_UPC);
    }

}



