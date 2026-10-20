package com.ecommerce.quickBuy.dto;


import java.math.BigDecimal;

public record Products (String productId,
                        String productName,
                        String productDescription,
                        BigDecimal productPrice)
   
{}
