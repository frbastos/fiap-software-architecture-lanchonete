package com.fiap.lanchonete.domain.orders.models;

import java.util.List;

public record OrderPersistence(
        String document,
        List<OrderItemPersistence> items
) {
}