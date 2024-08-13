package com.fiap.lanchonete.infrastructure.adapters.orders.mappers;

import com.fiap.lanchonete.domain.orders.models.OrderItem;
import com.fiap.lanchonete.infrastructure.adapters.orders.entity.OrderEntity;
import com.fiap.lanchonete.infrastructure.adapters.orders.entity.OrderItemEntity;

public class OrderItemMapper {

    public static OrderItem toDomain(OrderItemEntity orderItemEntity) {
        return new OrderItem(
                orderItemEntity.getId(),
                orderItemEntity.getProductId(),
                orderItemEntity.getUnitPrice(),
                orderItemEntity.getQuantity(),
                orderItemEntity.getObservation(),
                orderItemEntity.getTotalPrice()
        );
    }

    public static OrderItemEntity toPersistence(OrderItem orderItem, OrderEntity order) {
        return new OrderItemEntity(
                orderItem.getId(),
                orderItem.getProductId(),
                orderItem.getUnitPrice(),
                orderItem.getQuantity(),
                orderItem.getObservation(),
                orderItem.getTotalPrice(),
                order
        );
    }

}
