package dev.ted.supermarket;

import dev.ted.supermarket.application.CartService;
import dev.ted.supermarket.domain.DiscountRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class CheckoutPricerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckoutPricerApplication.class, args);
	}

	@Bean
	public CartService cartService() {
		return new CartService(upc -> BigDecimal.ZERO,
							   upc -> DiscountRule.NONE);

	}

}