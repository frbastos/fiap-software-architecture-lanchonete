package com.fiap.lanchonete.infrastructure.orders.api.dto;

import com.fiap.lanchonete.domain.orders.valueobjects.OrderState;

public record UpdateOrderStatusRequest(
    OrderState state
) {
}
