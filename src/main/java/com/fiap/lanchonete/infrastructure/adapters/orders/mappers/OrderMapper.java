package com.fiap.lanchonete.infrastructure.adapters.orders.mappers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiap.lanchonete.domain.customers.models.Customer;
import com.fiap.lanchonete.domain.orders.models.Order;
import com.fiap.lanchonete.domain.orders.models.OrderItem;
import com.fiap.lanchonete.infrastructure.adapters.customers.entity.CustomerEntity;
import com.fiap.lanchonete.infrastructure.adapters.customers.mapper.CustomerMapper;
import com.fiap.lanchonete.infrastructure.adapters.orders.entity.OrderEntity;
import com.fiap.lanchonete.infrastructure.adapters.orders.entity.OrderItemEntity;

@Component
public class OrderMapper {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    public Order toOrder(OrderEntity orderEntity) {
        
        Customer customer = orderEntity.getCustomer() != null
            ? customerMapper.toCustomer(orderEntity.getCustomer())
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
                ? customerMapper.toCustomerEntity(order.getCustomer())
                : null;

        OrderEntity orderEntity = new OrderEntity(
                    order.getId(),
                    customerEntity,
                    null,
                    order.getState(),
                    order.getTotalPrice());

        List<OrderItemEntity> ordersItemEntity = order.getItems()
            .stream()
            .map(orderItem -> orderItemMapper.toOrderItemEntity(orderItem))
            .peek(orderItemEntity -> orderItemEntity.setOrder(orderEntity))
            .toList();

        orderEntity.setItems(ordersItemEntity);

        return orderEntity;
    }

    public List<OrderItem> toOrderItems(OrderEntity orderEntity) {
       return orderEntity.getItems().stream().map(entity -> orderItemMapper.toOrderItem(entity)).toList();
    }

    public List<Order> toListOrderItem(List<OrderEntity> list) {
        return list.stream().map(item -> toOrder(item)).toList();
     }

}
