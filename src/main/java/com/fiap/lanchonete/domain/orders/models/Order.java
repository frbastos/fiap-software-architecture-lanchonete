package com.fiap.lanchonete.domain.orders.models;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Order {

    private final UUID id;
    //private final UUID customerId;
    private final List<OrderItem> items;
    private OrderState state;
    private final BigDecimal totalPrice;

    public UUID getId() {
        return id;
    }

    /*public UUID getCustomerId() {
        return customerId;
    }*/

    public List<OrderItem> getItems() {
        return items;
    }

    public OrderState getState() {
        return state;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public Order(
            UUID id,
            //UUID customerId,
            List<OrderItem> items,
            OrderState state,
            BigDecimal totalPrice
    ) {
        this.id = id;
        //this.customerId = customerId;
        this.items = items;
        this.state = state;
        this.totalPrice = totalPrice;
    }

    public Order(OrderPersistence persistence) {
        List<OrderItem> items = persistence.items().stream().map(OrderItem::new).toList();

        this.id = UUID.randomUUID();
        //this.customerId = persistence.customerId();
        this.items = items;
        this.state = OrderState.RECEIVED;
        this.totalPrice = items.stream().map(OrderItem::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void updateState(OrderState state) {
        this.state = state;
    }

}
