package com.fiap.lanchonete.infrastructure.adapters.orders.entity;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiap.lanchonete.infrastructure.adapters.products.entity.ProductEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_item")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private ProductEntity product;

    @DecimalMin("0.00")
    private BigDecimal unitPrice;

    private int quantity;

    @Column(columnDefinition = "TEXT")
    private String observation;

    @DecimalMin("0.00")
    private BigDecimal totalPrice;

    @ManyToOne
    private OrderEntity order;

}
