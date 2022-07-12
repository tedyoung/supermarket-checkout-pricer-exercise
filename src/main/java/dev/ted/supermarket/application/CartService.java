package dev.ted.supermarket.application;

import dev.ted.supermarket.application.port.ProductPriceFetcher;
import dev.ted.supermarket.domain.Cart;
import dev.ted.supermarket.domain.DiscountRule;
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
        DiscountRule discountRule = discountRuleFor(upc);
        Product product = new Product(upc, productPrice, discountRule);
        cart.add(product);
    }

    private DiscountRule discountRuleFor(String upc) {
        if (upc.equals("0987")) {
            return DiscountRule.TEN_PERCENT_OFF;
        }
        return DiscountRule.NONE;
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
