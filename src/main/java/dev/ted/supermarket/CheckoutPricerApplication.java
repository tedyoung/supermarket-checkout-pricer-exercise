package dev.ted.supermarket;

import dev.ted.supermarket.application.CartService;
import dev.ted.supermarket.application.port.DiscountFetcher;
import dev.ted.supermarket.application.port.ProductPriceFetcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CheckoutPricerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckoutPricerApplication.class, args);
	}

	@Bean
	public CartService cartService(ProductPriceFetcher productPriceFetcher,
								   DiscountFetcher discountFetcher) {
		return new CartService(productPriceFetcher,
							   discountFetcher);
	}

}