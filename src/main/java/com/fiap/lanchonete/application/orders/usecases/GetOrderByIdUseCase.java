package com.fiap.lanchonete.application.orders.usecases;

import java.util.Optional;
import java.util.UUID;

import com.fiap.lanchonete.domain.orders.entities.Order;

public interface GetOrderByIdUseCase {

    Optional<Order> getOrderById(UUID id);

}
