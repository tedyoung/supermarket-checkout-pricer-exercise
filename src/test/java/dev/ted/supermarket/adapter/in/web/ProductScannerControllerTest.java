package dev.ted.supermarket.adapter.in.web;

import dev.ted.supermarket.application.CartService;
import dev.ted.supermarket.application.port.DiscountFetcher;
import dev.ted.supermarket.application.port.ProductPriceFetcher;
import dev.ted.supermarket.domain.DiscountRule;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

class ProductScannerControllerTest {

    private static final String TOOTHPASTE_UPC = "9456";
    private static final ProductPriceFetcher DUMMY_PRODUCT_PRICE_FETCHER = (upc) -> BigDecimal.ZERO;
    private static final DiscountFetcher DUMMY_DISCOUNT_FETCHER = upc -> DiscountRule.NONE;

    @Test
    public void scanProductReturnsScanTemplateWithEmptyUpcAndCartTotal() throws Exception {
        ProductScannerController productScannerController =
                new ProductScannerController(new CartService(null, null, (upc, productPrice) -> {}));
        Model model = new ConcurrentModel();

        String page = productScannerController.scanProduct(model);

        assertThat(page)
                .isEqualTo("scan");
        assertThat(model.containsAttribute("upc"))
                .isTrue();
        String total = (String) model.getAttribute("total");
        assertThat(total)
                .isEqualTo("0");
    }

    @Test
    public void addProductRedirectsToRoot() throws Exception {
        CartService cartService = createCartServiceWithDummies();
        ProductScannerController productScannerController =
                new ProductScannerController(cartService);

        String page = productScannerController.addProduct(TOOTHPASTE_UPC);

        assertThat(page)
                .isEqualTo("redirect:/");
    }

    @Test
    public void postValidUpcThenProductAddedToCard() throws Exception {
        CartService cartService = createCartServiceWithDummies();
        ProductScannerController productScannerController =
                new ProductScannerController(cartService);

        productScannerController.addProduct(TOOTHPASTE_UPC);

        assertThat(cartService.finalizeOrder().products())
                .containsExactly(TOOTHPASTE_UPC);
    }

    @Test
    public void postEmptyUpcThenRedirectToErrorPage() throws Exception {
        CartService cartService = createCartServiceWithDummies();
        ProductScannerController productScannerController =
                new ProductScannerController(cartService);

        String page = productScannerController.addProduct("");

        assertThat(page)
                .isEqualTo("redirect:/error");
    }

    private CartService createCartServiceWithDummies() {
        return new CartService(
                DUMMY_PRODUCT_PRICE_FETCHER, DUMMY_DISCOUNT_FETCHER, (upc, productPrice) -> {});
    }

}