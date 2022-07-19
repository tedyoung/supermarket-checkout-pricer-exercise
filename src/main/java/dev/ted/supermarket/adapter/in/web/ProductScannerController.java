package dev.ted.supermarket.adapter.in.web;

import dev.ted.supermarket.application.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductScannerController {
    private final CartService cartService;

    public ProductScannerController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/")
    public String scanProduct(Model model) {
        model.addAttribute("upc", "");
        return "scan";
    }

    @PostMapping("/")
    public String addProduct(String upc) {
        cartService.addProduct(upc);
        return "redirect:/";
    }

}
