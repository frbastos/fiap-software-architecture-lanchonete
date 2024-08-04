package com.fiap.lanchonete.infrastructure.adapters.orders.mappers;

import com.fiap.lanchonete.domain.orders.entities.Order;
import com.fiap.lanchonete.infrastructure.adapters.customers.entity.CustomerEntity;
import com.fiap.lanchonete.infrastructure.adapters.orders.entity.OrderEntity;
import com.fiap.lanchonete.infrastructure.adapters.orders.entity.OrderItemEntity;

import java.util.List;

public class OrderMapper {

    public static OrderEntity toPersistence(Order order) {
        OrderEntity orderEntity = new OrderEntity(
                order.getId(),
                order.getCustomer().map(CustomerEntity::new).orElse(null),
                null,
                order.getState(),
                order.getTotalPrice()
        );

        List<OrderItemEntity> orderItems = order.getOrderItems()
                .stream()
                .map(item -> OrderItemMapper.toPersistence(item, orderEntity))
                .toList();

        orderEntity.setOrderItems(orderItems);

        return orderEntity;
    }

}
