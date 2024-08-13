package com.fiap.lanchonete.infrastructure.adapters.orders.entity;

import com.fiap.lanchonete.domain.orders.models.OrderState;
import com.fiap.lanchonete.infrastructure.adapters.customers.entity.CustomerEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
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
@Table(name = "order")
public class OrderEntity {

    @Id
    private UUID id;

    @ManyToOne(targetEntity = CustomerEntity.class)
    private UUID customerId;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItemEntity> items;

    @Enumerated(EnumType.STRING)
    private OrderState state;

    @DecimalMin("0.00")
    private BigDecimal totalPrice;

}
