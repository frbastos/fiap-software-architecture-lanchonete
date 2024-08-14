package com.fiap.lanchonete.domain.orders.ports.in;

import com.fiap.lanchonete.domain.orders.models.Order;

import java.util.Optional;
import java.util.UUID;

public interface GetOrderByIdInputPort {

    Optional<Order> getOrderById(UUID id);

}
