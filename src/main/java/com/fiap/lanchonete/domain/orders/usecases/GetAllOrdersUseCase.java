package com.fiap.lanchonete.domain.orders.usecases;

import com.fiap.lanchonete.domain.orders.models.Order;
import com.fiap.lanchonete.domain.orders.ports.in.GetAllOrdersInputPort;
import com.fiap.lanchonete.domain.orders.ports.out.GetAllOrdersOutputPort;

import java.util.List;

public class GetAllOrdersUseCase implements GetAllOrdersInputPort {

    private final GetAllOrdersOutputPort ordersRepository;

    public GetAllOrdersUseCase(GetAllOrdersOutputPort ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public List<Order> getAll() {
        return this.ordersRepository.getAll();
    }

}
