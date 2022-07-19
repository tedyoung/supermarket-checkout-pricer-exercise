package dev.ted.supermarket.application;

import dev.ted.supermarket.application.port.DiscountFetcher;
import dev.ted.supermarket.application.port.StubDiscountFetcher;
import dev.ted.supermarket.application.port.StubProductPriceFetcher;
import dev.ted.supermarket.domain.DiscountRule;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class AddProductViaCartServiceTest {

    private static final String TOOTHBRUSH_UPC = "0123";
    private static final String TOOTHPASTE_UPC = "9456";


    @Test
    public void twoItemsThenCartTotalPriceIsSumOfProductPrices() throws Exception {
        StubProductPriceFetcher productPricer = new StubProductPriceFetcher(
                TOOTHBRUSH_UPC, BigDecimal.valueOf(1),
                TOOTHPASTE_UPC, BigDecimal.valueOf(3));
        CartService cartService = new CartService(productPricer, 
                                                  StubDiscountFetcher.noDiscounts());

        cartService.addProduct(TOOTHBRUSH_UPC);
        cartService.addProduct(TOOTHPASTE_UPC);

        assertThat(cartService.total())
                .isEqualByComparingTo(BigDecimal.valueOf(1 + 3)); // evident data
    }

    @Test
    public void addToothpasteThenCartTotalPriceIsThreeDollars() throws Exception {
        StubProductPriceFetcher productPricer = new StubProductPriceFetcher(
                TOOTHPASTE_UPC, BigDecimal.valueOf(3));
        CartService cartService = new CartService(productPricer,
                                                  StubDiscountFetcher.noDiscounts());

        cartService.addProduct(TOOTHPASTE_UPC);

        assertThat(cartService.total())
                .isEqualByComparingTo("3");
    }

    @Test
    public void whereDiscountServiceHas10PercentDiscountRuleThenRuleIsApplied() throws Exception {
        StubProductPriceFetcher productPricer = new StubProductPriceFetcher(
                "0987", BigDecimal.valueOf(8));
        DiscountFetcher discountFetcher = new StubDiscountFetcher(
                "0987", DiscountRule.TEN_PERCENT_OFF);
        CartService cartService = new CartService(productPricer, discountFetcher);

        cartService.addProduct("0987");

        assertThat(cartService.total())
                .isEqualByComparingTo("7.2");
    }

}

