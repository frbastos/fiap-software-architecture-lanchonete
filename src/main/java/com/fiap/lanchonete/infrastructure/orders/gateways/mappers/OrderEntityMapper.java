package com.fiap.lanchonete.infrastructure.orders.gateways.mappers;

import java.util.List;

import com.fiap.lanchonete.domain.customers.entities.Customer;
import com.fiap.lanchonete.domain.orders.entities.Order;
import com.fiap.lanchonete.domain.orders.entities.OrderItem;
import com.fiap.lanchonete.infrastructure.customers.gateway.mappers.CustomerEntityMapper;
import com.fiap.lanchonete.infrastructure.customers.persistence.CustomerEntity;
import com.fiap.lanchonete.infrastructure.orders.persistence.OrderEntity;
import com.fiap.lanchonete.infrastructure.orders.persistence.OrderItemEntity;

public class OrderEntityMapper {

    private final CustomerEntityMapper customerEntityMapper;
    private final OrderItemEntityMapper orderItemEntityMapper;

    public OrderEntityMapper(CustomerEntityMapper customerEntityMapper, OrderItemEntityMapper orderItemEntityMapper) {
        this.customerEntityMapper = customerEntityMapper;
        this.orderItemEntityMapper = orderItemEntityMapper;
    }

    public Order toOrder(OrderEntity orderEntity) {
        
        Customer customer = orderEntity.getCustomer() != null
            ? customerEntityMapper.toCustomer(orderEntity.getCustomer())
            : null;

        return new Order(
                orderEntity.getId(),
                customer,
                toOrderItems(orderEntity),
                orderEntity.getState(),
                orderEntity.getTotalPrice()
        );
    }

    public OrderEntity toOrderEntity(Order order) {

        CustomerEntity customerEntity = order.getCustomer() != null
                ? customerEntityMapper.toCustomerEntity(order.getCustomer())
                : null;

        OrderEntity orderEntity = new OrderEntity(
                    order.getId(),
                    customerEntity,
                    null,
                    order.getState(),
                    order.getTotalPrice());

        List<OrderItemEntity> ordersItemEntity = order.getItems()
            .stream()
            .map(orderItem -> orderItemEntityMapper.toOrderItemEntity(orderItem))
            .peek(orderItemEntity -> orderItemEntity.setOrder(orderEntity))
            .toList();

        orderEntity.setItems(ordersItemEntity);

        return orderEntity;
    }

    public List<OrderItem> toOrderItems(OrderEntity orderEntity) {
       return orderEntity.getItems().stream().map(entity -> orderItemEntityMapper.toOrderItem(entity)).toList();
    }

    public List<Order> toListOrderItem(List<OrderEntity> list) {
        return list.stream().map(item -> toOrder(item)).toList();
     }

}
