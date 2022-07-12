package dev.ted.supermarket.application;

import dev.ted.supermarket.application.port.ProductPriceFetcherStub;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class AddProductViaCartServiceTest {

    private static final String TOOTHBRUSH_UPC = "0123";
    private static final String TOOTHPASTE_UPC = "9456";
    private static final String TEN_PERCENT_DISCOUNTED_UPC = "0987";


    @Test
    public void twoItemsThenCartTotalPriceIsSumOfProductPrices() throws Exception {
        ProductPriceFetcherStub productPricer = new ProductPriceFetcherStub(
                TOOTHBRUSH_UPC, BigDecimal.valueOf(1),
                TOOTHPASTE_UPC, BigDecimal.valueOf(3));
        CartService cartService = new CartService(productPricer, new StubDiscountFetcher());

        cartService.addProduct(TOOTHBRUSH_UPC);
        cartService.addProduct(TOOTHPASTE_UPC);

        assertThat(cartService.total())
                .isEqualByComparingTo(BigDecimal.valueOf(1 + 3)); // evident data
    }

    @Test
    public void addToothpasteThenCartTotalPriceIsThreeDollars() throws Exception {
        ProductPriceFetcherStub productPricer = new ProductPriceFetcherStub(
                TOOTHPASTE_UPC, BigDecimal.valueOf(3));
        CartService cartService = new CartService(productPricer, new StubDiscountFetcher());

        cartService.addProduct(TOOTHPASTE_UPC);

        assertThat(cartService.total())
                .isEqualByComparingTo("3");
    }

    @Test
    public void whereDiscountServiceHas10PercentDiscountRuleThenRuleIsApplied() throws Exception {
        ProductPriceFetcherStub productPricer = new ProductPriceFetcherStub(
                TEN_PERCENT_DISCOUNTED_UPC, BigDecimal.valueOf(8));
        CartService cartService = new CartService(productPricer, new StubDiscountFetcher());

        cartService.addProduct(TEN_PERCENT_DISCOUNTED_UPC);

        assertThat(cartService.total())
                .isEqualByComparingTo("7.2");
    }

}

