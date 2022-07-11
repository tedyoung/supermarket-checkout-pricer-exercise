package dev.ted.supermarket.application;

import dev.ted.supermarket.application.port.ProductPriceFetcher;
import dev.ted.supermarket.domain.Cart;
import dev.ted.supermarket.domain.Product;
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
        // "coordinate" fetching the price from an external provider
        BigDecimal productPrice = productPriceFetcher.priceFor(upc);
        cart.add(new Product(upc, productPrice));
    }

    public Receipt finalizeOrder() {
        requireCartNotEmpty();

        Receipt receipt = cart.receipt();

        cart = new Cart();

        return receipt;
    }

    public boolean isEmpty() {
        return cart.isEmpty();
    }

    private void requireCartNotEmpty() {
        if (cart.isEmpty()) {
            throw new NoProductsInCartException();
        }
    }

}
