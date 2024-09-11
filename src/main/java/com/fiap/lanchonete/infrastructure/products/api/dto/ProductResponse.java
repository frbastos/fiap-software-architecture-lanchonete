package com.fiap.lanchonete.infrastructure.products.api.dto;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiap.lanchonete.domain.products.valueobjects.Category;

public record ProductResponse(
    UUID id,
    String description,
    BigDecimal price,
    Category category
) {

}
