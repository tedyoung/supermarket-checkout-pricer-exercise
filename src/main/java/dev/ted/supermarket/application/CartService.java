package dev.ted.supermarket.application;

import dev.ted.supermarket.application.port.ProductPriceFetcher;
import dev.ted.supermarket.domain.Cart;
import dev.ted.supermarket.domain.Receipt;

import java.math.BigDecimal;

public class CartService {

    private final ProductPriceFetcher productPriceFetcher;
    private Cart cart = new Cart();

    public CartService(ProductPriceFetcher productPriceFetcher) {
        this.productPriceFetcher = productPriceFetcher;
    }

    public BigDecimal total() {
        return cart.total();
    }

    public void addProduct(String upc) {
        BigDecimal productPrice = productPriceFetcher.priceFor(upc);
        cart.add(upc, productPrice);
    }

    public Receipt finalizeOrder() {
        cart.requireCartNotEmpty();

        Receipt receipt = cart.receipt();

        cart = new Cart();

        return receipt;
    }

    public boolean isEmpty() {
        return cart.isEmpty();
    }

}
