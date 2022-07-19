package dev.ted.supermarket.adapter.in.web;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Tag("integration")
@WebMvcTest
public class ProductScannerWebMvcTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getRootPathIs200Ok() throws Exception {
        mockMvc.perform(get("/"))
               .andExpect(status().isOk());
    }

    @Test
    public void postToRootPathIsRedirect() throws Exception {
        mockMvc.perform(post("/"))
               .andExpect(status().is3xxRedirection());
    }

}
