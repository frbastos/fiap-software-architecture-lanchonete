package com.fiap.lanchonete.domain.orders.models;

import java.util.List;
import java.util.UUID;

public record OrderPersistence(
        //UUID customerId,
        List<OrderItemPersistence> items
) {
}