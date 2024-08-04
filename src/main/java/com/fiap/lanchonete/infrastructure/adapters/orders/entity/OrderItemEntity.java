package com.fiap.lanchonete.infrastructure.adapters.orders.entity;

import com.fiap.lanchonete.infrastructure.adapters.products.entity.ProductEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItemEntity {

    @Id
    private UUID id;

    @ManyToOne
    private ProductEntity product;

    @NotNull
    private int quantity;

    @NotNull
    private BigDecimal totalPrice;

    private String observation;

    @ManyToOne(cascade = CascadeType.ALL)
    private OrderEntity order;

}
