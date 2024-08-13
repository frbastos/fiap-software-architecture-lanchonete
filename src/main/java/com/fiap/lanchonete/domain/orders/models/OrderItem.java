package com.fiap.lanchonete.domain.orders.models;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderItem {

    private final UUID id;
    private final UUID productId;
    private final BigDecimal unitPrice;
    private final int quantity;
    private final String observation;
    private final BigDecimal totalPrice;

    public UUID getId() {
        return id;
    }

    public UUID getProductId() {
        return productId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getObservation() {
        return observation;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public OrderItem(
            UUID id,
            UUID productId,
            BigDecimal unitPrice,
            int quantity,
            String observation,
            BigDecimal totalPrice
    ) {
        this.id = id;
        this.productId = productId;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.observation = observation;
        this.totalPrice = totalPrice;
    }

    public OrderItem(OrderItemPersistence persistence) {
        this.id = UUID.randomUUID();
        this.productId = persistence.productId();
        this.unitPrice = persistence.price();
        this.quantity = persistence.quantity();
        this.observation = persistence.observation();
        this.totalPrice = persistence.price().multiply(BigDecimal.valueOf(persistence.quantity()));
    }
}
