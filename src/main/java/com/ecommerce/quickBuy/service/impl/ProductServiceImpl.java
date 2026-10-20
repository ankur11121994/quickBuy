package com.ecommerce.quickBuy.service.impl;

import com.ecommerce.quickBuy.dto.Products;
import com.ecommerce.quickBuy.entity.Product;
import com.ecommerce.quickBuy.repository.ProductRepository;
import com.ecommerce.quickBuy.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Optional<Products> getProductById(Long productId) {
        return productRepository.findAll(Sort.by(Sort.Order.asc("id"))).stream()
                .filter(product -> productId.equals(product.getId())).findFirst().map(product -> {

                            return new Products(
                                    product.getSku(),
                                    product.getName(),
                                    product.getDescription(),
                                    product.getUnitPrice()
                            );
                        }
                );
    }

    @Override
    public List<Products> getAllProducts() {
        var productsEntity = productRepository.findAll(Sort.by(Sort.Order.asc("id")));
        return productsEntity.stream().map(product -> new Products(
                        product.getSku(),
                        product.getName(),
                        product.getDescription(),
                        product.getUnitPrice()
                )
        ).toList();
    }
}
