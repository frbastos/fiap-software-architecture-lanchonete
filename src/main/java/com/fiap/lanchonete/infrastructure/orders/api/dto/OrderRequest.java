package com.fiap.lanchonete.infrastructure.orders.api.dto;

import java.util.List;

public record OrderRequest(
        String document,
        List<OrderItemRequest> items
) {
}