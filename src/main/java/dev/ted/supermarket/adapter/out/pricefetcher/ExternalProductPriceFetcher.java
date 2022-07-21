package dev.ted.supermarket.adapter.out.pricefetcher;

import dev.ted.supermarket.application.port.ProductPriceFetcher;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Component
public class ExternalProductPriceFetcher implements ProductPriceFetcher {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String priceFetcherUrl = "http://localhost:8003/prices/{upc}";

    @Override
    public BigDecimal priceFor(String upc) {
        PriceResponse priceResponse =
                restTemplate.getForObject(priceFetcherUrl,
                                          PriceResponse.class,
                                          upc);
        return priceResponse.price();
    }
}
