package dev.ted.supermarket.adapter.in.web;

import dev.ted.supermarket.application.port.ProductPriceFetcher;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Tag("integration")
@WebMvcTest
public class ProductScannerWebMvcTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductPriceFetcher productPriceFetcher;

    @Test
    public void getRootPathIs200Ok() throws Exception {
        mockMvc.perform(get("/"))
               .andExpect(status().isOk());
    }

    @Test
    public void postToRootPathIsRedirect() throws Exception {
        mockMvc.perform(post("/")
                                .param("upc", "0123")
               )
               .andExpect(status().is3xxRedirection())
               .andExpect(redirectedUrl("/"));
    }

}
