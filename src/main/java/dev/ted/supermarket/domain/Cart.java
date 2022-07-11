package dev.ted.supermarket.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// ideas for naming:
// Order, Bag, Scale
public class Cart {
    private final List<Product> products = new ArrayList<>();
    private BigDecimal total = BigDecimal.ZERO;

    public boolean add(Product product) {
        BigDecimal price = discountedProductPrice(product);
        if (products.contains(product)) {
            price = product.productPrice().divide(BigDecimal.valueOf(2));
        }
        total = total.add(price);
        return products.add(product);
    }

    private BigDecimal discountedProductPrice(Product product) {
        BigDecimal actualPrice = product.productPrice();
        if (product.upc().equals("0987")) {
            actualPrice = actualPrice.multiply(BigDecimal.valueOf(0.9));
        }
        return actualPrice;
    }

    public BigDecimal total() {
        return total;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public Receipt receipt() {
        List<String> upcs = products
                .stream()
                .map(Product::upc)
                .toList();
        return new Receipt(total, upcs);
    }
}