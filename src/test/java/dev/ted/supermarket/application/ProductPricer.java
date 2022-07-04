package dev.ted.supermarket.application;

public class ProductPricer {
    static final int TOOTHBRUSH_PRICE = 1;
    static final int TOOTHPASTE_PRICE = 3;
    static final String TOOTHBRUSH_UPC = "0123";
    static final String TOOTHPASTE_UPC = "9456";

    public ProductPricer() {
    }

    int priceFor(String upc) {
        int itemPrice = 0;
        if (upc.equals(TOOTHBRUSH_UPC)) {
            itemPrice = TOOTHBRUSH_PRICE;
        } else if (upc.equals(TOOTHPASTE_UPC)) {
            itemPrice = TOOTHPASTE_PRICE;
        }
        return itemPrice;
    }
}