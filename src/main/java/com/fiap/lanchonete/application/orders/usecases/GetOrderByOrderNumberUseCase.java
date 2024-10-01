package com.fiap.lanchonete.application.orders.usecases;

import com.fiap.lanchonete.domain.orders.entities.Order;

import java.util.Optional;

public interface GetOrderByOrderNumberUseCase {

    Optional<Order> findOrderByOrderNumber(Long orderNumber);
}
