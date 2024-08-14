package com.fiap.lanchonete.infrastructure.adapters.orders.entity;

import com.fiap.lanchonete.infrastructure.adapters.products.entity.ProductEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_item")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    
    private UUID productId;

    @DecimalMin("0.00")
    private BigDecimal unitPrice;

    private int quantity;

    @Column(columnDefinition = "TEXT")
    private String observation;

    @DecimalMin("0.00")
    private BigDecimal totalPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    private OrderEntity order;

}
