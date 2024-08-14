package com.fiap.lanchonete.domain.orders.models;

import java.util.UUID;

public record OrderItemPersistence(
        UUID productId,
        int quantity,
        String observation
) {
}
