package dev.ted.supermarket.application.port;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound(String upc) {
        super("Product not found for UPC: " + upc);
    }
}
