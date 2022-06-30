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
        String productRow = productToReceiptEntry(product);
        return """
                %s
                                    
                Total Price: $%s
                """.formatted(productRow,
                              cart.totalPrice());
    }

    private String productToReceiptEntry(Product product) {
        return """
                %s $%s"""
                .formatted((product.name()),
                           product.price());
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
