package com.fiap.lanchonete.infrastructure.orders.api.dto;

import java.util.List;

public record OrderGroupedResponse(
        List<OrderFollowUp> readyOrders,
        List<OrderFollowUp> preparingOrders,
        List<OrderFollowUp> receivedOrders
) {
}
