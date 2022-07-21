package dev.ted.supermarket;

import dev.ted.supermarket.application.CartService;
import dev.ted.supermarket.application.port.ProductPriceFetcher;
import dev.ted.supermarket.domain.DiscountRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CheckoutPricerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckoutPricerApplication.class, args);
	}

	@Bean
	public CartService cartService(ProductPriceFetcher productPriceFetcher) {
		return new CartService(productPriceFetcher,
							   upc -> DiscountRule.NONE);
	}

}