package com.fiap.lanchonete.domain.orders.entities;

import com.fiap.lanchonete.domain.customers.Customer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Order {
    private final UUID id;
    private final Optional<Customer> customer;
    private final List<OrderItem> orderItems;
    private OrderState state;
    private final BigDecimal totalPrice;

    private Order(
            UUID id,
            Optional<Customer> customer,
            List<OrderItem> orderItems,
            OrderState state,
            BigDecimal totalPrice
    ) {
        this.id = id;
        this.customer = customer;
        this.orderItems = orderItems;
        this.state = state;
        this.totalPrice = totalPrice;
    }

    public UUID getId() {
        return this.id;
    }

    public Optional<Customer> getCustomer() {
        return this.customer;
    }

    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    public OrderState getState() {
        return this.state;
    }

    public void changeState(OrderState state) {
        this.state = state;
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public static Order create(
            Optional<Customer> customer,
            List<OrderItem> items
    ) {
        UUID id = UUID.randomUUID();
        OrderState state = OrderState.RECEIVED;
        BigDecimal totalPrice = items.stream().map(OrderItem::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);

        return new Order(
                id,
                customer,
                items,
                state,
                totalPrice
        );
    }

    public static Order restore(
            UUID id,
            Optional<Customer> customer,
            List<OrderItem> orderItems,
            OrderState state,
            BigDecimal totalPrice
    ) {
        return new Order(
                id,
                customer,
                orderItems,
                state,
                totalPrice
        );
    }
}
