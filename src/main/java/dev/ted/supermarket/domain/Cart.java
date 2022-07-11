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
    private Set<Product> eligibleProducts;

    public boolean add(Product product) {
        return products.add(product);
    }

    private BigDecimal discountedIndividualProductPrice(Product product) {
        BigDecimal actualPrice = product.productPrice();
        if (product.upc().equals("0987")) {
            return actualPrice.multiply(BigDecimal.valueOf(0.9));
        }
        return discountedGroupProductPrice(product);
    }

    private BigDecimal discountedGroupProductPrice(Product product) {
        if (eligibleForHalfOffDiscount(product)) {
            return product.productPrice().divide(BigDecimal.valueOf(2));
        }
        eligibleProducts.add(product);
        return product.productPrice();
    }

    private boolean eligibleForHalfOffDiscount(Product product) {
        return eligibleProducts.contains(product);
    }

    public BigDecimal total() {
        eligibleProducts = new HashSet<>();
        return products.stream()
                       .map(this::discountedIndividualProductPrice)
                       .reduce(BigDecimal::add)
                       .orElse(BigDecimal.ZERO);
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
}