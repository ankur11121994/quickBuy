package com.ecommerce.quickBuy.dto;


import java.math.BigDecimal;

public record Products (String productId,
                        String productName,
                        String imageUrl,
                        String productDescription,
                        BigDecimal productPrice)
   
{}
