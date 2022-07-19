package dev.ted.supermarket.adapter.in.web;

import dev.ted.supermarket.application.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductScannerController {
    private final CartService cartService;

    @Autowired
    public ProductScannerController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/")
    public String scanProduct(Model model) {
        model.addAttribute("upc", "");
        return "scan";
    }

    @PostMapping("/")
    public String addProduct(
            @RequestParam(name = "upc", defaultValue = "") String upc) {
        if (upc.isBlank()) {
            return "redirect:/error";
        }
        cartService.addProduct(upc);
        return "redirect:/";
    }

}
