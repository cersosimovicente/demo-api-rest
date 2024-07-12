package com.laboratorio.demoapirest;

import com.laboratorio.demoapirest.controller.ProductController;
import com.laboratorio.demoapirest.entity.Product;
import com.laboratorio.demoapirest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ProductService productService;

    void testGetProductsById() throws Exception {
        // Arrange
        Product product = new Product(1000L, "Pantalon", 100, 10);
        when(productService.getProductById(1000L)).thenReturn(product);
        mockMvc.perform(get("/products/1000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1000L))
                .andExpect(jsonPath("$.name").value("Pantalon"))
                .andExpect(jsonPath("$.price").value(100))
                .andExpect(jsonPath("$.stock").value(10));
    }
}
