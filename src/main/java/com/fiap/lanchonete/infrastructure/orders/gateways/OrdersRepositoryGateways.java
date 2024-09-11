package com.fiap.lanchonete.infrastructure.orders.gateways;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiap.lanchonete.application.orders.gateways.OrderGateway;
import com.fiap.lanchonete.domain.orders.entities.Order;
import com.fiap.lanchonete.infrastructure.orders.gateways.mappers.OrderEntityMapper;
import com.fiap.lanchonete.infrastructure.orders.persistence.OrderEntity;
import com.fiap.lanchonete.infrastructure.orders.persistence.OrdersRepository;
import com.fiap.lanchonete.shared.exception.NotFoundException;

@Component
public class OrdersRepositoryGateways implements OrderGateway
{

    @Autowired
    private OrdersRepository repository;

    @Autowired
    private OrderEntityMapper orderMapper;

    @Override
    public List<Order> getAll() {
        List<OrderEntity> ordersEntities = this.repository.findAll();
        return orderMapper.toListOrderItem(ordersEntities);
    }

    @Override
    public Optional<Order> getById(UUID id) throws NotFoundException {
        return this.repository.findById(id).map(order -> orderMapper.toOrder(order));
    }

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = orderMapper.toOrderEntity(order);
        orderEntity = this.repository.save(orderEntity);
        return orderMapper.toOrder(orderEntity);
    }

    @Override
    public Order saveAndFlush(Order order) {
        OrderEntity orderEntity = orderMapper.toOrderEntity(order);
        orderEntity = this.repository.saveAndFlush(orderEntity);
        return orderMapper.toOrder(orderEntity);
    }

}
