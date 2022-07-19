package dev.ted.supermarket.adapter.in.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductScannerController {

    @GetMapping("/")
    public String scanProduct() {
        return "scan";
    }

}
