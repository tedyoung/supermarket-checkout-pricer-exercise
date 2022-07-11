package dev.ted.supermarket.domain;

import java.math.BigDecimal;

public record Product(String upc, BigDecimal productPrice) {
}