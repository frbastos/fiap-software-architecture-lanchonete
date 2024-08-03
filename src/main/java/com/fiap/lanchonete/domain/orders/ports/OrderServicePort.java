package com.fiap.lanchonete.domain.orders.ports;

import com.fiap.lanchonete.domain.orders.dtos.CreateOrderRequest;

public interface OrderServicePort {
    void create(CreateOrderRequest request);
}
