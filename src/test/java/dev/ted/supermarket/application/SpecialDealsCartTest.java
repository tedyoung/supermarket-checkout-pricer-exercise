package dev.ted.supermarket.application;

import static dev.ted.supermarket.application.ProductPricer.TOOTHBRUSH_UPC;
import static org.assertj.core.api.Assertions.*;

public class SpecialDealsCartTest {

//    @Test
    public void twoSameItemsThenSecondIsDiscountedHalfOff() throws Exception {
        CartService cartService = new CartService(new ProductPricer());

        cartService.addProduct(TOOTHBRUSH_UPC);
        cartService.addProduct(TOOTHBRUSH_UPC);

        assertThat(cartService.total())
                .isEqualTo("1.5");
    }

}



