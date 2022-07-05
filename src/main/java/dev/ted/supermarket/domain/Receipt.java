package dev.ted.supermarket.domain;

import java.math.BigDecimal;
import java.util.List;

public record Receipt(BigDecimal total, List<String> products) {
}
