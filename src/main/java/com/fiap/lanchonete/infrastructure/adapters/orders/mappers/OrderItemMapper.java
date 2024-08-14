package com.fiap.lanchonete.infrastructure.adapters.orders.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiap.lanchonete.domain.orders.models.OrderItem;
import com.fiap.lanchonete.domain.products.models.Product;
import com.fiap.lanchonete.infrastructure.adapters.orders.entity.OrderItemEntity;
import com.fiap.lanchonete.infrastructure.adapters.products.entity.ProductEntity;
import com.fiap.lanchonete.infrastructure.adapters.products.mappers.ProductMapper;

@Component
public class OrderItemMapper {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderMapper orderMapper;

    public OrderItem toOrderItem(OrderItemEntity orderItemEntity) {

        Product product = productMapper.toProduct(orderItemEntity.getProduct());

        return new OrderItem(
                orderItemEntity.getId(),
                product,
                orderItemEntity.getUnitPrice(),
                orderItemEntity.getQuantity(),
                orderItemEntity.getObservation(),
                orderItemEntity.getTotalPrice()
        );
    }

    public OrderItemEntity toOrderItemEntity(OrderItem orderItem) {

        ProductEntity product = productMapper.toProductEntity(orderItem.getProduct());

        return new OrderItemEntity(
                orderItem.getId(),
                product,
                orderItem.getUnitPrice(),
                orderItem.getQuantity(),
                orderItem.getObservation(),
                orderItem.getTotalPrice(),
                null
        );
    }

}
