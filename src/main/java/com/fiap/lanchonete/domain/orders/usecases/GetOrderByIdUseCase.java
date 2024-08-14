package com.fiap.lanchonete.domain.orders.usecases;

import com.fiap.lanchonete.domain.orders.models.Order;
import com.fiap.lanchonete.domain.orders.ports.in.GetOrderByIdInputPort;
import com.fiap.lanchonete.domain.orders.ports.out.GetOrderByIdOutputPort;

import java.util.Optional;
import java.util.UUID;

public class GetOrderByIdUseCase implements GetOrderByIdInputPort {

    private final GetOrderByIdOutputPort ordersRepository;

    public GetOrderByIdUseCase(GetOrderByIdOutputPort ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public Optional<Order> getOrderById(UUID id) {
        return this.ordersRepository.getById(id);
    }

}
