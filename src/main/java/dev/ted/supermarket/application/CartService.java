package dev.ted.supermarket.application;

import dev.ted.supermarket.application.port.ProductPriceFetcher;
import dev.ted.supermarket.domain.Cart;
import dev.ted.supermarket.domain.Receipt;

import java.math.BigDecimal;

public class CartService {

    private final ProductPriceFetcher productPriceFetcher;
    private final Cart cart = new Cart();

    private BigDecimal total = BigDecimal.ZERO;
    private boolean isEmpty = true;

    public CartService(ProductPriceFetcher productPriceFetcher) {
        this.productPriceFetcher = productPriceFetcher;
    }

    public BigDecimal total() {
        return total;
    }

    public void addProduct(String upc) {
        cart.add(upc);
        total = total.add(productPriceFetcher.priceFor(upc));
        isEmpty = false;
    }

    public Receipt finalizeOrder() {
        requireCartNotEmpty();

        Receipt receipt = new Receipt(total, cart.products());

        total = BigDecimal.ZERO;
        isEmpty = true;

        return receipt;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    private void requireCartNotEmpty() {
        if (isEmpty) {
            throw new NoProductsInCartException();
        }
    }
}
