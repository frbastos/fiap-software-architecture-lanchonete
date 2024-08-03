package com.fiap.lanchonete.domain.orders.ports;

import com.fiap.lanchonete.domain.orders.entities.Order;

public interface OrdersRepositoryPort {
    void save(Order order);
}
