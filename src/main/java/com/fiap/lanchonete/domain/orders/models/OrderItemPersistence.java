package com.fiap.lanchonete.domain.orders.models;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderItemPersistence(
        UUID productId,
        BigDecimal price,
        int quantity,
        String observation
) {
}
