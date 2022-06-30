package dev.ted.supermarket.adapter.in.scanner;

import dev.ted.supermarket.domain.Cart;

public class ScannerPrinter {
    private Cart cart;

    public ScannerPrinter(Cart cart) {
        this.cart = cart;
    }

    public String receiptForNonEmptyCart() {
        return """
                %s $%s
                                    
                Total Price: $%s
                """.formatted(cart.productName(),
                              cart.totalPrice(),
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
