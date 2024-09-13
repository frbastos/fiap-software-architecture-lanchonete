package com.fiap.lanchonete.infrastructure.orders.persistence;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiap.lanchonete.infrastructure.products.persistence.ProductEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @DecimalMin("0.00")
    @JoinColumn(name = "unit_price")
    private BigDecimal unitPrice;

    private int quantity;

    private String observation;

    @DecimalMin("0.00")
    @JoinColumn(name = "total_price")
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

}
