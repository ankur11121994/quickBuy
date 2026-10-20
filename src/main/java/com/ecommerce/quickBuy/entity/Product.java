package com.ecommerce.quickBuy.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String sku;
    private String name;
    private String description;

    @Column(name = "unit_price", precision = 15, scale = 2)
    private BigDecimal unitPrice;
    private String imageUrl;
    private Boolean active;
    private Integer unitsInStock;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;

}
