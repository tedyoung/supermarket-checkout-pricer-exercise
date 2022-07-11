package dev.ted.supermarket.application;

import dev.ted.supermarket.application.port.ProductPriceFetcher;
import dev.ted.supermarket.domain.Receipt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartService {

    private final ProductPriceFetcher productPriceFetcher;

    private BigDecimal total = BigDecimal.ZERO;
    private boolean isEmpty = true;
    private List<String> products = new ArrayList<>();

    public CartService(ProductPriceFetcher productPriceFetcher) {
        this.productPriceFetcher = productPriceFetcher;
    }

    public BigDecimal total() {
        return total;
    }

    public void addProduct(String upc) {
        products.add(upc);
        total = total.add(productPriceFetcher.priceFor(upc));
        isEmpty = false;
    }

    public Receipt finalizeOrder() {
        requireCartNotEmpty();

        Receipt receipt = new Receipt(total, products);

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
