package dev.ted.supermarket.application;

import java.math.BigDecimal;
import java.util.List;

public record Receipt(BigDecimal total, List<String> products) {
}
