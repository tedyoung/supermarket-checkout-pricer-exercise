package dev.ted.supermarket.domain;

public class Cart {

    private int productPrice = 0;

    public int totalPrice() {
        return productPrice;
    }

    public void add(String productName, int productPrice) {
        this.productPrice += productPrice;
    }

    public String receipt() {
        return """
                Total Price: $%s
                """.formatted(totalPrice());
    }
}
