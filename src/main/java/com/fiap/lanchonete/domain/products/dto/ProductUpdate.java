package com.fiap.lanchonete.domain.products.dto;

import java.math.BigDecimal;

import com.fiap.lanchonete.domain.products.Category;

public record ProductUpdate(
        String description,
        BigDecimal price,
        Category category) {
}
