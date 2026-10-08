package com.ecommerce.quickBuy.controllers;

import com.ecommerce.quickBuy.dto.Products;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ProductController {

    @GetMapping("/products")
    public ResponseEntity<List<Products>> getProducts() {
        Products products = new Products();
        products.setProductId("1");
        products.setProductName("Sample Product");
        products.setProductDescription("This is a sample product description.");
        products.setProductPrice(19.99);

        return ResponseEntity.ok(List.of(products));
    }
}
