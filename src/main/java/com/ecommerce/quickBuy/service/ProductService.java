package com.ecommerce.quickBuy.service;

import com.ecommerce.quickBuy.dto.Products;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public Optional<Products> getProductById(Long productId);
    public List<Products> getAllProducts();
}
