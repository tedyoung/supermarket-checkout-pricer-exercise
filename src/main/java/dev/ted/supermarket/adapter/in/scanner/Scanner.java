package dev.ted.supermarket.adapter.in.scanner;

import dev.ted.supermarket.domain.Cart;

public class Scanner {
    private Cart cart;

    public Scanner(Cart cart) {
        this.cart = cart;
    }

    public String receipt() {
        return cart.receipt();
    }
}
