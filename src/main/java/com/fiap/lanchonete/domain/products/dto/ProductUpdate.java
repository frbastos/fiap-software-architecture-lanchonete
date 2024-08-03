package com.fiap.lanchonete.domain.products.dto;

import java.math.BigDecimal;

import com.fiap.lanchonete.domain.products.Category;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductUpdate(
        @NotBlank  String description,
        @DecimalMin(value = "0.0") BigDecimal price,
        @NotNull Category category) {
}
