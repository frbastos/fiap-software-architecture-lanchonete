package com.fiap.lanchonete.application.products.usecases.commands;

import java.math.BigDecimal;

import com.fiap.lanchonete.domain.products.valueobjects.Category;

public record UpdateProductCommand(
    Long id,
    String description,
    BigDecimal price,
    Category category
) {

}
