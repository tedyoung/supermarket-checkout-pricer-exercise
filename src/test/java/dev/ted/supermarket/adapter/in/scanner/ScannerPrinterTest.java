package dev.ted.supermarket.adapter.in.scanner;

import dev.ted.supermarket.domain.Cart;
import dev.ted.supermarket.domain.Product;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ScannerPrinterTest {

    @Test
    public void receiptShowsZeroPriceWhenNoItemsScanned() throws Exception {
        Cart cart = new Cart();
        ScannerPrinter scannerPrinter = new ScannerPrinter(cart);

        assertThat(scannerPrinter.receipt())
                .isEqualTo("""
                           Total Price: $0
                           """
                );
    }

    @Test
    public void receiptShowsItemAndPriceForOneItemScanned() throws Exception {
        Cart cart = new Cart();
        ScannerPrinter scannerPrinter = new ScannerPrinter(cart);

        cart.add(new Product("Toothbrush", 1));

        assertThat(scannerPrinter.receipt())
                .isEqualTo("""
                            Toothbrush $1

                            Total Price: $1
                            """);
    }

    public void receiptShowsMultipleItemNamesAndPricesAndTotal() throws Exception {
        Cart cart = new Cart();
        ScannerPrinter scannerPrinter = new ScannerPrinter(cart);

        cart.add(new Product("Toothpaste", 2));
        cart.add(new Product("Toothbrush", 1));

        assertThat(scannerPrinter.receipt())
                .isEqualTo("""
                            Toothpaste $2
                            Toothbrush $1

                            Total Price: $3
                            """);
    }
}
