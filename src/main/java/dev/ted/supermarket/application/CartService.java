package dev.ted.supermarket.application;

import dev.ted.supermarket.application.port.CartNotifier;
import dev.ted.supermarket.application.port.DiscountFetcher;
import dev.ted.supermarket.application.port.ProductPriceFetcher;
import dev.ted.supermarket.domain.Cart;
import dev.ted.supermarket.domain.DiscountRule;
import dev.ted.supermarket.domain.Product;
import dev.ted.supermarket.domain.Receipt;

import java.math.BigDecimal;

public class CartService {

    private final ProductPriceFetcher productPriceFetcher;
    private final DiscountFetcher discountFetcher;
    private final CartNotifier cartNotifier;
    private Cart cart = new Cart();

    public CartService(ProductPriceFetcher productPriceFetcher,
                       DiscountFetcher discountFetcher,
                       CartNotifier cartNotifier) {
        this.productPriceFetcher = productPriceFetcher;
        this.discountFetcher = discountFetcher;
        this.cartNotifier = cartNotifier;
    }

    public BigDecimal total() {
        return cart.total();
    }

    public void addProduct(String upc) {
        // "coordinate" fetching the price from an external provider
        BigDecimal productPrice = productPriceFetcher.priceFor(upc);
        DiscountRule discountRule = discountFetcher.discountRuleFor(upc);
        // create object
        Product product = new Product(upc, productPrice, discountRule);
        // "persist"
        cart.add(product);
        // notify
        cartNotifier.productAdded(upc, productPrice);
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
