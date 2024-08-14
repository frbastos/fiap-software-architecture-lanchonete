package com.fiap.lanchonete.infrastructure.adapters.orders.mappers;

import com.fiap.lanchonete.domain.orders.models.Order;
import com.fiap.lanchonete.infrastructure.adapters.orders.entity.OrderEntity;
import com.fiap.lanchonete.infrastructure.adapters.orders.entity.OrderItemEntity;

import java.util.List;

public class OrderMapper {

    public static Order toDomain(OrderEntity orderEntity) {
        return new Order(
                orderEntity.getId(),
                //orderEntity.getCustomerId(),
                orderEntity.getItems().stream().map(OrderItemMapper::toDomain).toList(),
                orderEntity.getState(),
                orderEntity.getTotalPrice()
        );
    }

    public static OrderEntity toPersistence(Order order) {
        OrderEntity orderEntity = new OrderEntity(
                order.getId(),
                //order.getCustomerId(),
                null,
                order.getState(),
                order.getTotalPrice()
        );

        List<OrderItemEntity> orderItemEntities = order.getItems()
                .stream()
                .map((item) -> OrderItemMapper.toPersistence(item, orderEntity))
                .toList();

        orderEntity.setItems(orderItemEntities);

        return orderEntity;
    }

}
