package com.fiap.lanchonete.infrastructure.adapters.orders.mappers;

import com.fiap.lanchonete.domain.orders.entities.OrderItem;
import com.fiap.lanchonete.infrastructure.adapters.orders.entity.OrderEntity;
import com.fiap.lanchonete.infrastructure.adapters.orders.entity.OrderItemEntity;
import com.fiap.lanchonete.infrastructure.adapters.products.entity.ProductEntity;

public class OrderItemMapper {

    public static OrderItemEntity toPersistence(OrderItem orderItem, OrderEntity order) {
        ProductEntity product = new ProductEntity(
                orderItem.getProduct()
        );

        return new OrderItemEntity(
                orderItem.getId(),
                product,
                orderItem.getQuantity(),
                orderItem.getTotalPrice(),
                orderItem.getObservation(),
                order
        );
    }

}
