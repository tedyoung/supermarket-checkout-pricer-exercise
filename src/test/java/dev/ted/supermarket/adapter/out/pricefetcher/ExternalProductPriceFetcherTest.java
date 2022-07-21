package dev.ted.supermarket.adapter.out.pricefetcher;

import dev.ted.supermarket.application.port.ProductPriceFetcher;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

@Tag("manual")
class ExternalProductPriceFetcherTest {

    @Test
    public void priceForReturnsTenFromExternalService() throws Exception {
        ProductPriceFetcher productPriceFetcher = new ExternalProductPriceFetcher();

        BigDecimal price = productPriceFetcher.priceFor("123456789012");

        assertThat(price)
                .isEqualByComparingTo(BigDecimal.TEN);
    }

}