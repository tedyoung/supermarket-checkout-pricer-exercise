package dev.ted.supermarket.application;

public class CartService {

    private final ProductPricer productPricer = new ProductPricer();
    private int total = 0;

    public int total() {
        return total;
    }

    public void addProduct(String upc) {
        total += productPricer.priceFor(upc);
    }

}
