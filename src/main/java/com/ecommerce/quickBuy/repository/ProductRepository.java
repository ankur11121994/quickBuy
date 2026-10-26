package com.ecommerce.quickBuy.repository;

import com.ecommerce.quickBuy.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByProductCategory_Id(@Param("categoryId") Long categoryId,  Pageable pageable);
}
