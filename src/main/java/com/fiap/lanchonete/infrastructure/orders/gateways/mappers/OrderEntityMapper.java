package com.fiap.lanchonete.infrastructure.orders.gateways.mappers;

import java.util.List;

import com.fiap.lanchonete.domain.customers.entities.Customer;
import com.fiap.lanchonete.domain.orders.entities.Order;
import com.fiap.lanchonete.domain.orders.entities.OrderItem;
import com.fiap.lanchonete.domain.payment.entities.Payment;
import com.fiap.lanchonete.infrastructure.customers.gateway.mappers.CustomerEntityMapper;
import com.fiap.lanchonete.infrastructure.customers.persistence.CustomerEntity;
import com.fiap.lanchonete.infrastructure.orders.persistence.OrderEntity;
import com.fiap.lanchonete.infrastructure.orders.persistence.OrderItemEntity;
import com.fiap.lanchonete.infrastructure.payment.gateways.mappers.PaymentEntityMapper;
import com.fiap.lanchonete.infrastructure.payment.persistence.PaymentEntity;

public class OrderEntityMapper {

    private final CustomerEntityMapper customerEntityMapper;
    private final OrderItemEntityMapper orderItemEntityMapper;
    private final PaymentEntityMapper paymentEntityMapper;

    public OrderEntityMapper(
            CustomerEntityMapper customerEntityMapper,
            OrderItemEntityMapper orderItemEntityMapper,
            PaymentEntityMapper paymentEntityMapper) {

        this.customerEntityMapper = customerEntityMapper;
        this.orderItemEntityMapper = orderItemEntityMapper;
        this.paymentEntityMapper = paymentEntityMapper;
    }

    public Order toOrder(OrderEntity orderEntity) {

        Customer customer = orderEntity.getCustomer() != null
                ? customerEntityMapper.toCustomer(orderEntity.getCustomer())
                : null;

        Payment payment = orderEntity.getPayment() != null
                ? paymentEntityMapper.toPayment(orderEntity.getPayment())
                : null;

        Order order = new Order(
                orderEntity.getId(),
                customer,
                toOrderItems(orderEntity),
                orderEntity.getState(),
                orderEntity.getTotalPrice(),
                orderEntity.getPaymentConfirmationStatus(),
                payment,
                orderEntity.getCreationTime(),
                orderEntity.getOrderNumber());

        return order;

    }

    public OrderEntity toOrderEntity(Order order) {

        CustomerEntity customerEntity = order.getCustomer() != null
                ? customerEntityMapper.toCustomerEntity(order.getCustomer())
                : null;

        PaymentEntity paymentEntity = order.getPayment() != null
                ? paymentEntityMapper.toEntity(order.getPayment())
                : null;

        OrderEntity orderEntity = new OrderEntity(
                order.getId(),
                customerEntity,
                null,
                order.getState(),
                order.getTotalPrice(),
                order.getPaymentConfirmationStatus(),
                paymentEntity,
                order.getCreationTime(),order.getOrderNumber());

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
