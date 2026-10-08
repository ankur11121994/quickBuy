package com.ecommerce.quickBuy.dto;

import lombok.Data;

@Data
public class Products {
    private  String productId;
    private String productName;
    private String productDescription;
    private Double productPrice;
}
