package dev.ted.supermarket.application;

public class NoProductsInCartException extends RuntimeException {
    public NoProductsInCartException() {
        super();
    }

    public NoProductsInCartException(String message) {
        super(message);
    }
}
