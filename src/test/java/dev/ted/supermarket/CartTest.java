package dev.ted.supermarket;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CartTest {

    @Test
    void emptyCartHasTotalPriceOfZero() {
        Cart cart = new Cart();

        assertThat(cart.totalPrice())
                .isZero();
    }

    @Test
    public void addToothbrushProductThenTotalPriceIsOneDollar() throws Exception {
        Cart cart = new Cart();

        cart.add("Toothbrush", 1);

        assertThat(cart.totalPrice())
                .isEqualTo(1);
    }
}
