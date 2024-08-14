package com.fiap.lanchonete.domain.orders.models;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiap.lanchonete.domain.products.models.Product;

public class OrderItem {

    private UUID id;
    private Product product;
    private BigDecimal unitPrice;
    private int quantity;
    private String observation;
    private BigDecimal totalPrice;

    public UUID getId() {
        return id;
    }

    public Product getProduct() {
        return product;
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
            Product product, 
            BigDecimal unitPrice, 
            int quantity, 
            String observation,
            BigDecimal totalPrice) {
        this.id = id;
        this.product = product;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.observation = observation;
        this.totalPrice = totalPrice;
    }

    public OrderItem(
            UUID id,
            Product product,
            int quantity,
            String observation
    ) {
        this(id, product, product.getPrice(), quantity, observation, BigDecimal.ZERO); 
        this.totalPrice = unitPrice.multiply(BigDecimal.valueOf(quantity));      
    }

}
