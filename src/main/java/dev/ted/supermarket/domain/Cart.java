package dev.ted.supermarket.domain;

public class Cart {

    private int totalPrice = 0;

    public int totalPrice() {
        return totalPrice;
    }

    public void add(String productName, int productPrice) {
        this.totalPrice += productPrice;
    }

    public String receipt() {
        if (isEmpty()) {
            return receiptForEmptyCart();
        }
        return receiptForNonEmptyCart();
    }

    private boolean isEmpty() {
        return totalPrice() == 0;
    }

    private String receiptForEmptyCart() {
        return """
                Total Price: $0
                """;
    }

    private String receiptForNonEmptyCart() {
        return """
                Toothbrush $%s
                                    
                Total Price: $%s
                """.formatted(totalPrice(),
                              totalPrice());
    }
}
