package com.ecommerce.quickBuy.repository;

import com.ecommerce.quickBuy.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public interface CategoryRepository extends JpaRepository<ProductCategory, Long> {
}
