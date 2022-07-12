package dev.ted.supermarket.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// ideas for naming:
// Order, Bag, Scale
public class Cart {
    private final List<Product> products = new ArrayList<>();
    private Set<Product> eligibleProductsForHalfOffDiscount; // Primitive Obsession

    public void add(Product product) {
        products.add(product);
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public Receipt receipt() {
        List<String> upcs = products
                .stream()
                .map(Product::upc)
                .toList();
        return new Receipt(total(), upcs);
    }

    // Query method: does not change EXTERNALLY OBSERVABLE state
    public BigDecimal total() {
        eligibleProductsForHalfOffDiscount = new HashSet<>();
        return products.stream()
                       .map(this::discountedIndividualProductPrice)
                       .reduce(BigDecimal::add)
                       .orElse(BigDecimal.ZERO);
    }

    private BigDecimal discountedIndividualProductPrice(Product product) {
        BigDecimal actualPrice = product.productPrice();
        if (eligibleForHalfOffDiscount(product)) {
            return product.productPrice().divide(BigDecimal.valueOf(2));
        }
        if (eligibleForTenPercentDiscount(product)) {
            return actualPrice.multiply(BigDecimal.valueOf(0.9));
        }
        eligibleProductsForHalfOffDiscount.add(product);
        return product.productPrice();
    }

    private boolean eligibleForTenPercentDiscount(Product product) {
        return product.discountRule() == DiscountRule.NONE
                && onlyOneOf(product);
    }

    private boolean onlyOneOf(Product product) {
        return products.stream()
                       .filter(p -> p.equals(product))
                       .count() == 1;
    }

    private boolean eligibleForHalfOffDiscount(Product product) {
        return eligibleProductsForHalfOffDiscount.contains(product);
    }

}