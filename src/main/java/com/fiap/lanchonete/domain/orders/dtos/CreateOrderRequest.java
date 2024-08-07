package com.fiap.lanchonete.domain.orders.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateOrderRequest(
        String customerDocument,
        @NotNull List<OrderItemRequest> items
) {
}

