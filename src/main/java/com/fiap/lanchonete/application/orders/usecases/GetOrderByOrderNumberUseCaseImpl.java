package com.fiap.lanchonete.application.orders.usecases;

import com.fiap.lanchonete.application.orders.gateways.OrderGateway;
import com.fiap.lanchonete.domain.orders.entities.Order;

import java.util.Optional;

public class GetOrderByOrderNumberUseCaseImpl implements GetOrderByOrderNumberUseCase {

    private final OrderGateway orderGateway;

    public GetOrderByOrderNumberUseCaseImpl(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public Optional<Order> findOrderByOrderNumber(Long orderNumber) {
        return this.orderGateway.getByOrderNumber(orderNumber);
    }
}
