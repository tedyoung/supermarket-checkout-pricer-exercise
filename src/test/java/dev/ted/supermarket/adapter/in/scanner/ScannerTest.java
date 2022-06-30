package dev.ted.supermarket.adapter.in.scanner;

import dev.ted.supermarket.domain.Cart;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ScannerTest {

    @Test
    public void receiptShowsZeroPriceWhenNoItemsScanned() throws Exception {
        Cart cart = new Cart();
        Scanner scanner = new Scanner(cart);

        assertThat(scanner.receipt())
                .isEqualTo("""
                           Total Price: $0
                           """
                );
    }

}
