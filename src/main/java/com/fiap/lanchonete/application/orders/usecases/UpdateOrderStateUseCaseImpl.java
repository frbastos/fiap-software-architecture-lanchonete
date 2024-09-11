package com.fiap.lanchonete.application.orders.usecases;

import java.util.UUID;

import com.fiap.lanchonete.application.orders.gateways.OrderGateway;
import com.fiap.lanchonete.domain.orders.entities.Order;
import com.fiap.lanchonete.domain.orders.valueobjects.OrderState;
import com.fiap.lanchonete.shared.exception.NotFoundException;

public class UpdateOrderStateUseCaseImpl implements UpdateOrderStateUseCase {

     private final OrderGateway orderGateway;
     
    public UpdateOrderStateUseCaseImpl(
        OrderGateway orderGateway){
        this.orderGateway = orderGateway;
    }

    @Override
    public void updateState(UUID id, OrderState state) {
        Order order = orderGateway.getById(id).orElseThrow((NotFoundException::new));
        order.updateState(state);
        orderGateway.save(order);
    }

}
