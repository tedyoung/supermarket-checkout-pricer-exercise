package dev.ted.supermarket.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CartTest {
    private static final String TOOTHBRUSH_UPC = "0123";

    @Test
    public void cartTotalPriceStartsAtZeroAndIsEmpty() throws Exception {
        Cart cart = new Cart();

        assertThat(cart.total())
                .isZero();
        assertThat(cart.isEmpty())
                .isTrue();
    }

    @Test
    public void addToothbrushThenCartTotalPriceIsOneDollar() throws Exception {
        Cart cart = new Cart();

        cart.add(TOOTHBRUSH_UPC, BigDecimal.ONE);

        assertThat(cart.total())
                .isEqualTo("1");
        assertThat(cart.isEmpty())
                .isFalse();
    }

    @Test
    public void addProductThenReceiptHasProductWithTotalPrice() throws Exception {
        Cart cart = new Cart();

        cart.add(TOOTHBRUSH_UPC, BigDecimal.ONE);

        assertThat(cart.receipt())
                .isEqualTo(new Receipt(BigDecimal.ONE,
                                       List.of(TOOTHBRUSH_UPC)));
    }


}