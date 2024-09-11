package com.fiap.lanchonete.infrastructure.orders.gateways.mappers;

import org.springframework.stereotype.Component;

import com.fiap.lanchonete.domain.orders.entities.OrderItem;
import com.fiap.lanchonete.domain.products.entities.Product;
import com.fiap.lanchonete.infrastructure.orders.persistence.OrderItemEntity;
import com.fiap.lanchonete.infrastructure.products.gateways.mappers.ProductEntityMapper;
import com.fiap.lanchonete.infrastructure.products.persistence.ProductEntity;

@Component
public class OrderItemEntityMapper {

    private final ProductEntityMapper productMapper;

    public OrderItemEntityMapper(ProductEntityMapper productMapper) {
        this.productMapper = productMapper;
    }

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
