package com.fiap.lanchonete.domain.orders.models;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.fiap.lanchonete.domain.customers.models.Customer;

public class Order {

    private UUID id;
    private Customer customer;
    private List<OrderItem> items;
    private OrderState state;
    private BigDecimal totalPrice;

    public UUID getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public OrderState getState() {
        return state;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public Order(UUID id, Customer customer, List<OrderItem> items, OrderState state, BigDecimal totalPrice) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.state = state;
        this.totalPrice = totalPrice;
    }

    public Order(
            UUID id,
            Customer customer,
            List<OrderItem> items) {

        this(id, customer, items, OrderState.RECEIVED, BigDecimal.ZERO);
        this.totalPrice = calculateTotalPrice(items);
    }

    private BigDecimal calculateTotalPrice(List<OrderItem> items) {
        return items.stream()
                .map(OrderItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void updateState(OrderState state) {
        this.state = state;
    }

}
