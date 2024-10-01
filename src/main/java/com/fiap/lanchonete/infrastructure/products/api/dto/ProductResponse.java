package com.fiap.lanchonete.infrastructure.products.api.dto;

import java.math.BigDecimal;

import com.fiap.lanchonete.domain.products.valueobjects.Category;

public record ProductResponse(
    Long id,
    String description,
    BigDecimal price,
    Category category
) {

}
