package com.fiap.lanchonete.domain.orders.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record OrderItemRequest(
        @NotNull UUID productId,
        @NotNull int quantity,
        @NotNull String observation
) {
}
