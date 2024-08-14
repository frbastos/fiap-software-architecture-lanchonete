package com.fiap.lanchonete.infrastructure.adapters.orders.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.fiap.lanchonete.domain.orders.models.OrderState;
import com.fiap.lanchonete.infrastructure.adapters.customers.entity.CustomerEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private CustomerEntity customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItemEntity> items;

    @Enumerated(EnumType.STRING)
    private OrderState state;

    @DecimalMin("0.00")
    private BigDecimal totalPrice;


}
