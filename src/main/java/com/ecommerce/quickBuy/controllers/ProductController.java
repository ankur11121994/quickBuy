package com.ecommerce.quickBuy.controllers;

import com.ecommerce.quickBuy.dto.Products;
import com.ecommerce.quickBuy.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/v1")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Products>> getProducts() {
        log.info("Fetching all products");
         return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Products> findProductById(@PathVariable Long id) {
        log.info("Fetching Product By id {}", id);
        return ResponseEntity.of(productService.getProductById(id));
    }
}
