package dev.ted.supermarket.adapter.in.web;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ProductScannerControllerTest {

    @Test
    public void scanProductReturnsScanTemplate() throws Exception {
        ProductScannerController productScannerController =
                new ProductScannerController();

        String page = productScannerController.scanProduct();

        assertThat(page)
                .isEqualTo("scan");
    }

}