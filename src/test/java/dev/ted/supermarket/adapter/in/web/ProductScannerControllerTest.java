package dev.ted.supermarket.adapter.in.web;

import dev.ted.supermarket.application.CartService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.*;

class ProductScannerControllerTest {

    private static final String TOOTHPASTE_UPC = "9456";

    @Test
    public void scanProductReturnsScanTemplate() throws Exception {
        ProductScannerController productScannerController =
                new ProductScannerController(new CartService(null, null));
        Model model = new ConcurrentModel();

        String page = productScannerController.scanProduct(model);

        assertThat(page)
                .isEqualTo("scan");
        assertThat(model.containsAttribute("upc"))
                .isTrue();
    }

    @Test
    public void addProductRedirectsToRoot() throws Exception {
        ProductScannerController productScannerController =
                new ProductScannerController(new CartService(null, null));

        String page = productScannerController.addProduct("");

        assertThat(page)
                .isEqualTo("redirect:/");
    }

    @Test
    @Disabled
    public void postValidUpcThenProductAddedToCard() throws Exception {
        CartService cartService = new CartService(null, null);
        ProductScannerController productScannerController =
                new ProductScannerController(cartService);

        productScannerController.addProduct(TOOTHPASTE_UPC);

        assertThat(cartService.finalizeOrder().products())
                .containsExactly(TOOTHPASTE_UPC);
    }

}