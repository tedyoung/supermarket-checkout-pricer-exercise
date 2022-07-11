package dev.ted.supermarket.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// ideas for naming:
// Order, Bag, Scale
public class Cart {
    private final List<String> products = new ArrayList<>();
    private BigDecimal total = BigDecimal.ZERO;

    public boolean add(Product product) {
        BigDecimal price = discountedProductPrice(product.upc(), product.productPrice());
        if (products.contains(product.upc())) {
            price = product.productPrice().divide(BigDecimal.valueOf(2));
        }
        total = total.add(price);
        return products.add(product.upc());
    }

    private BigDecimal discountedProductPrice(String upc, BigDecimal productPrice) {
        BigDecimal actualPrice = productPrice;
        if (upc.equals("0987")) {
            actualPrice = productPrice.multiply(BigDecimal.valueOf(0.9));
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
        return new Receipt(total, List.copyOf(products));
    }
}