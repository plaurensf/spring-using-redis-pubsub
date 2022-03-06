package laurens.poc.springusingredispub.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import laurens.poc.springusingredispub.entities.Product;
import laurens.poc.springusingredispub.services.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.MimeTypeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(ProductControllerTest.class)
class ProductControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    public MockMvc mockMvc;

    @Mock
    ProductService productService;

    @Test
    void getProducts() throws Exception {
        List<Product> productList = new ArrayList(Arrays.asList(
                Product.builder().id(1).name("Cafe").price(1000),
                Product.builder().id(2).name("Arroz").price(2500)
            )
        );

        Mockito.when(productService.getAllProducts()).thenReturn(productList);

        final ResultActions result = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/products")
                .accept(MimeTypeUtils.APPLICATION_JSON_VALUE));

        assertEquals(200, result.andReturn().getResponse().getStatus());
    }

    @Test
    void getProductById() {
    }

    @Test
    void addProduct() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void modifyProduct() {
    }
}