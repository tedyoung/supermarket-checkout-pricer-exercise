package dev.ted.supermarket.adapter.in.scanner;

import dev.ted.supermarket.domain.Cart;
import dev.ted.supermarket.domain.Product;

public class ScannerPrinter {
    private Cart cart;

    public ScannerPrinter(Cart cart) {
        this.cart = cart;
    }

    public String receiptForNonEmptyCart() {
        Product product = cart.contents().findFirst().get();
        return """
                %s $%s
                                    
                Total Price: $%s
                """.formatted(product.productName(),
                              product.productPrice(),
                              cart.totalPrice());
    }

    public String receipt() {
        if (cart.totalPrice() == 0) {
            return receiptForEmptyCart();
        }
        return receiptForNonEmptyCart();
    }


    private String receiptForEmptyCart() {
        return """
                Total Price: $0
                """;
    }

}
