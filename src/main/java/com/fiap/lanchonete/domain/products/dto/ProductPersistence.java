package com.fiap.lanchonete.domain.products.dto;

import com.fiap.lanchonete.domain.products.Category;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductPersistence(
        @NotBlank String description,
        @DecimalMin(value = "0.0") BigDecimal price,
        @NotNull Category category) {
}
