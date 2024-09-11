package com.fiap.lanchonete.application.orders.usecases;

import java.util.List;

import com.fiap.lanchonete.application.orders.gateways.OrderGateway;
import com.fiap.lanchonete.domain.orders.entities.Order;

public class GetAllOrdersUseCaseImpl implements GetAllOrdersUseCase {

     private final OrderGateway orderGateway;

    public GetAllOrdersUseCaseImpl(OrderGateway orderGateway){
        this.orderGateway = orderGateway;
    }

    @Override
    public List<Order> getAll() {
        return orderGateway.getAll();
    }

}
