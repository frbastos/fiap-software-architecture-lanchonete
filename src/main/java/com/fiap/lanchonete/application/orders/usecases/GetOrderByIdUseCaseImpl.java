package com.fiap.lanchonete.application.orders.usecases;

import java.util.Optional;

import com.fiap.lanchonete.application.orders.gateways.OrderGateway;
import com.fiap.lanchonete.domain.orders.entities.Order;

public class GetOrderByIdUseCaseImpl implements GetOrderByIdUseCase {

   private final OrderGateway orderGateway;

    public GetOrderByIdUseCaseImpl(OrderGateway orderGateway){
        this.orderGateway = orderGateway;
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderGateway.getById(id);
    }

}
