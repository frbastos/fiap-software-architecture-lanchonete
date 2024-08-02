package com.fiap.lanchonete.domain.orders.entities;

import com.fiap.lanchonete.domain.products.Product;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderItem {
    private final UUID id;
    private final Product product;
    private final int quantity;
    private final BigDecimal totalPrice;
    private final String observation;

    private OrderItem(
            UUID id,
            Product product,
            int quantity,
            BigDecimal totalPrice,
            String observation
    ) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.observation = observation;
    }

    public UUID getId() {
        return this.id;
    }

    public Product getProduct() {
        return this.product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public String getObservation() {
        return this.observation;
    }

    public static OrderItem create(Product product, int quantity, String obs) {
        UUID id = UUID.randomUUID();
        BigDecimal totalPrice = product.getPrice().multiply(new BigDecimal(quantity));

        return new OrderItem(id, product, quantity, totalPrice, obs);
    }

    public static OrderItem restore(UUID id, Product product, int quantity, BigDecimal totalPrice, String obs) {
        return new OrderItem(id, product, quantity, totalPrice, obs);
    }
}
