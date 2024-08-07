package com.fiap.lanchonete.infrastructure.adapters.orders.repository;

import com.fiap.lanchonete.domain.orders.entities.Order;
import com.fiap.lanchonete.domain.orders.ports.OrdersRepositoryPort;
import com.fiap.lanchonete.infrastructure.adapters.orders.entity.OrderEntity;
import com.fiap.lanchonete.infrastructure.adapters.orders.mappers.OrderMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrdersRepositoryImp implements OrdersRepositoryPort {

    @Autowired
    private OrdersRepository repository;

    public OrdersRepositoryImp(OrdersRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Order order) {
        OrderEntity mappedOrder = OrderMapper.toPersistence(order);

        repository.save(mappedOrder);
    }
}
