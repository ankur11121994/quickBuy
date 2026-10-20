package com.ecommerce.quickBuy.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_category")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

}
