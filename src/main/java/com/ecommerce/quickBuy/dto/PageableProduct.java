package com.ecommerce.quickBuy.dto;

import java.util.List;

public record PageableProduct(int totalPages, int totalElements, int currentPage, int pageSize,
                List<Products> items) {}
