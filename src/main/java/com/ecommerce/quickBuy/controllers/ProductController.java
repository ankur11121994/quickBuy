package com.ecommerce.quickBuy.controllers;

import com.ecommerce.quickBuy.dto.PageableProduct;
import com.ecommerce.quickBuy.dto.Products;
import com.ecommerce.quickBuy.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/products/category/{categoryId}")
    public ResponseEntity<PageableProduct> findProductsByCategoryId(@PathVariable Long categoryId, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        log.info("Fetching Products By categoryId {}", categoryId);
        return ResponseEntity.ok(productService.getProductsByCategoryId(categoryId, page, size));
    }
}
