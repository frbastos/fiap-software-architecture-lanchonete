package com.fiap.lanchonete.infrastructure.adapters.orders.entity;

import com.fiap.lanchonete.domain.orders.models.OrderState;
import com.fiap.lanchonete.infrastructure.adapters.customers.entity.CustomerEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;

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
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

   /* @ManyToOne(targetEntity = CustomerEntity.class)
    private UUID customerId;*/

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItemEntity> items;

    @Enumerated(EnumType.STRING)
    private OrderState state;

    @DecimalMin("0.00")
    private BigDecimal totalPrice;


}
