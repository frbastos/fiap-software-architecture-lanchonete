package com.fiap.lanchonete.domain.orders.entities;

import java.math.BigDecimal;

import com.fiap.lanchonete.domain.products.entities.Product;

public class OrderItem {

    private Long id;
    private Product product;
    private BigDecimal unitPrice;
    private int quantity;
    private String observation;
    private BigDecimal totalPrice;

    public Long getId() {
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
            Long id, 
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
            Long id,
            Product product,
            int quantity,
            String observation
    ) {
        this(id, product, product.getPrice(), quantity, observation, BigDecimal.ZERO); 
        this.totalPrice = unitPrice.multiply(BigDecimal.valueOf(quantity));      
    }

}
