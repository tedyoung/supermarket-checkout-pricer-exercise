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
        return receiptForNonEmptyCart();
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
