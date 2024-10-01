package com.fiap.lanchonete.infrastructure.orders.gateways;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fiap.lanchonete.application.orders.gateways.OrderGateway;
import com.fiap.lanchonete.domain.orders.entities.Order;
import com.fiap.lanchonete.infrastructure.orders.gateways.mappers.OrderEntityMapper;
import com.fiap.lanchonete.infrastructure.orders.persistence.OrderEntity;
import com.fiap.lanchonete.infrastructure.orders.persistence.OrdersRepository;
import com.fiap.lanchonete.shared.exception.NotFoundException;

public class OrdersRepositoryGateways implements OrderGateway
{
    private final OrdersRepository repository;
    private final OrderEntityMapper orderMapper;

    public OrdersRepositoryGateways(OrdersRepository repository, OrderEntityMapper orderMapper) {
        this.repository = repository;
        this.orderMapper = orderMapper;
    }

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

    @Override
    public Optional<Order> getByOrderNumber(Long orderNumber) throws NotFoundException {
        return this.repository.findByOrderNumber(orderNumber).map(orderMapper::toOrder);
    }

    @Override
    public List<Order> getAllOrderDesc() {
        List<OrderEntity> orderDesc = this.repository.findAllOrderByDateCreation();
        return orderMapper.toListOrderItem(orderDesc);
    }

}
