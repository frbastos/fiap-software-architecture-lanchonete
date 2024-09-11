package com.fiap.lanchonete.application.products.usecases.commands;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiap.lanchonete.domain.products.valueobjects.Category;

public record UpdateProductCommand(
    UUID id,
    String description,
    BigDecimal price,
    Category category
) {

}
