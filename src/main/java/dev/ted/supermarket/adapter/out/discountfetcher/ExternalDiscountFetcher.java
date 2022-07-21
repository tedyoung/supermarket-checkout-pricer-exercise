package dev.ted.supermarket.adapter.out.discountfetcher;

import dev.ted.supermarket.application.port.DiscountFetcher;
import dev.ted.supermarket.domain.DiscountRule;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExternalDiscountFetcher implements DiscountFetcher {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String discountFetcherUrl = "http://localhost:8069/discounts/{upc}";

    @Override
    public DiscountRule discountRuleFor(String upc) {
        DiscountResponse discountResponse =
                restTemplate.getForObject(discountFetcherUrl,
                                          DiscountResponse.class,
                                          upc);

        return DiscountRuleTranslator.toRule(discountResponse.ruleCode());
    }

}
