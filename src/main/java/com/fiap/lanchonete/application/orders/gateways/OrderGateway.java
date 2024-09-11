package com.fiap.lanchonete.application.orders.gateways;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fiap.lanchonete.domain.orders.entities.Order;
import com.fiap.lanchonete.shared.exception.NotFoundException;

public interface OrderGateway {

    List<Order> getAll();

    Optional<Order> getById(UUID id) throws NotFoundException;

    Order save(Order order);

    Order saveAndFlush(Order order);

}