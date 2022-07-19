package dev.ted.supermarket.adapter.in.web;

import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.*;

class ProductScannerControllerTest {

    @Test
    public void scanProductReturnsScanTemplate() throws Exception {
        ProductScannerController productScannerController =
                new ProductScannerController();
        Model model = new ConcurrentModel();

        String page = productScannerController.scanProduct(model);

        assertThat(page)
                .isEqualTo("scan");
        assertThat(model.containsAttribute("upc"))
                .isTrue();
    }

}