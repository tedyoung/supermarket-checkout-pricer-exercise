package dev.ted.supermarket.adapter.out.pricefetcher;

import java.math.BigDecimal;

// DTO specific to the NanoPriceService
public record PriceResponse(String upc, BigDecimal price) {
}
