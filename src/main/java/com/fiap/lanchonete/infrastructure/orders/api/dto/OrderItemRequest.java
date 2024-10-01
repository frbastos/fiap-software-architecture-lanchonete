package com.fiap.lanchonete.infrastructure.orders.api.dto;

public record OrderItemRequest(
        Long productId,
        int quantity,
        String observation
) {
}
