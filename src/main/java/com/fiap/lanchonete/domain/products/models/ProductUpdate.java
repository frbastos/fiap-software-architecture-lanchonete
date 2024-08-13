package com.fiap.lanchonete.domain.products.models;

import java.math.BigDecimal;

public record ProductUpdate(
        String description,
        BigDecimal price,
        Category category) {
}
