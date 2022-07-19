package dev.ted.supermarket.adapter.in.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductScannerController {

    @GetMapping("/")
    public String scanProduct(Model model) {
        model.addAttribute("upc", "");
        return "scan";
    }

}
