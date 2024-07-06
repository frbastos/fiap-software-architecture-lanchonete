package com.fiap.lanchonete.domain.products.dto;

import com.fiap.lanchonete.domain.products.Category;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponse(UUID id, String description, BigDecimal price, Category category) {
}
