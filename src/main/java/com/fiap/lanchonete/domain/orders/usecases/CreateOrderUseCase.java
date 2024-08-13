package com.fiap.lanchonete.domain.orders.usecases;

import com.fiap.lanchonete.domain.orders.models.Order;
import com.fiap.lanchonete.domain.orders.models.OrderPersistence;
import com.fiap.lanchonete.domain.orders.ports.in.CreateOrderInputPort;
import com.fiap.lanchonete.domain.orders.ports.out.SaveOrderOutputPort;

public class CreateOrderUseCase implements CreateOrderInputPort {

    private final SaveOrderOutputPort ordersRepository;

    public CreateOrderUseCase(SaveOrderOutputPort ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public void createOrder(OrderPersistence persistence) {
        Order order = new Order(persistence);

        this.ordersRepository.save(order);
    }

}
