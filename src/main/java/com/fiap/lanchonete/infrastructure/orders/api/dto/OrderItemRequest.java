package com.fiap.lanchonete.infrastructure.orders.api.dto;

import java.util.UUID;

public record OrderItemRequest(
        UUID productId,
        int quantity,
        String observation
) {
}
