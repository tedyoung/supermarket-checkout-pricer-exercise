package dev.ted.supermarket.domain;

public class Cart {

    private String productName;
    private int totalPrice = 0;

    public int totalPrice() {
        return totalPrice;
    }

    public void add(String productName, int productPrice) {
        this.productName = productName;
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
                %s $%s
                                    
                Total Price: $%s
                """.formatted(productName,
                              totalPrice(),
                              totalPrice());
    }
}
