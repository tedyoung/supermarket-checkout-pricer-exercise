package dev.ted.supermarket.application;

public class CartService {

    private static final int TOOTHBRUSH_PRICE = 1;
    private static final int TOOTHPASTE_PRICE = 3;
    private static final String TOOTHBRUSH_UPC = "0123";
    private static final String TOOTHPASTE_UPC = "9456";
    private int total = 0;

    public int total() {
        return total;
    }

    public void addProduct(String upc) {
        total += priceFor(upc);
    }

    private int priceFor(String upc) {
        int itemPrice = 0;
        if (upc.equals(TOOTHBRUSH_UPC)) {
            itemPrice = TOOTHBRUSH_PRICE;
        } else if (upc.equals(TOOTHPASTE_UPC)) {
            itemPrice = TOOTHPASTE_PRICE;
        }
        return itemPrice;
    }
}
