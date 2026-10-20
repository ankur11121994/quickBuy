package com.ecommerce.quickBuy.repository;

import com.ecommerce.quickBuy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
