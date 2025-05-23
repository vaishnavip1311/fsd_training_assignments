package com.ecom.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ecom.exception.ProductNotFoundException;
import com.ecom.model.Product;
import com.ecom.service.ProductService;

public class ProductServiceTest {
	
	ProductService productService;

    @BeforeEach
    void setup() {
        productService = new ProductService();
    }

    @Test
    void testGetProductByInvalidId() {
        assertThrows(ProductNotFoundException.class, () -> productService.getById(999));
    }

    @Test
    void testGetProductsByCategory() {
        List<Product> products = productService.getProductsByCategory(201);
        assertNotNull(products);
    }

}
