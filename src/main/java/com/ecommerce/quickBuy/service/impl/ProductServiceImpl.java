package com.ecommerce.quickBuy.service.impl;

import com.ecommerce.quickBuy.dto.PageableProduct;
import com.ecommerce.quickBuy.dto.Products;
import com.ecommerce.quickBuy.repository.CategoryRepository;
import com.ecommerce.quickBuy.repository.ProductRepository;
import com.ecommerce.quickBuy.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Optional<Products> getProductById(Long productId) {
        return productRepository.findAll(Sort.by(Sort.Order.asc("id"))).stream()
                .filter(product -> productId.equals(product.getId())).findFirst().map(product -> {

                            return new Products(
                                    product.getSku(),
                                    product.getName(),
                                    product.getImageUrl(),
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
                        product.getImageUrl(),
                        product.getDescription(),
                        product.getUnitPrice()
                )
        ).toList();
    }

    @Override
    public PageableProduct getProductsByCategoryId(Long categoryId, Integer page, Integer size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
    var categoryProduct = productRepository.findByProductCategory_Id(categoryId, pageable);
    var res = new PageableProduct(
            categoryProduct.getTotalPages(),
            (int) categoryProduct.getTotalElements(),
            categoryProduct.getNumber(),
            categoryProduct.getSize(),
            categoryProduct.getContent().stream().map(product -> new Products(
                    product.getSku(),
                    product.getName(),
                    product.getImageUrl(),
                    product.getDescription(),
                    product.getUnitPrice()
            )).toList()
    );
    return res;
    }
}
