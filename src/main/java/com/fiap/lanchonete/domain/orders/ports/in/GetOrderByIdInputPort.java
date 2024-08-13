package com.fiap.lanchonete.domain.orders.ports.in;

import com.fiap.lanchonete.domain.orders.models.Order;

import java.util.UUID;

public interface GetOrderByIdInputPort {

    Order getOrderById(UUID id);

}
