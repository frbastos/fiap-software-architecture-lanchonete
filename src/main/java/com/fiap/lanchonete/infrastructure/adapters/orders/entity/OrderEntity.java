package com.fiap.lanchonete.infrastructure.adapters.orders.entity;

import com.fiap.lanchonete.domain.orders.entities.OrderState;
import com.fiap.lanchonete.infrastructure.adapters.customers.entity.CustomerEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    private UUID id;

    @ManyToOne
    private CustomerEntity customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItemEntity> orderItems;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderState state;

    @NotNull
    private BigDecimal totalPrice;

}
