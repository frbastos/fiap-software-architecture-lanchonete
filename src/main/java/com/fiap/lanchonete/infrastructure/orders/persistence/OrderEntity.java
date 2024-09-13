package com.fiap.lanchonete.infrastructure.orders.persistence;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.fiap.lanchonete.domain.orders.valueobjects.OrderState;
import com.fiap.lanchonete.domain.orders.valueobjects.PaymentConfirmationStatus;
import com.fiap.lanchonete.infrastructure.customers.persistence.CustomerEntity;
import com.fiap.lanchonete.infrastructure.payment.persistence.PaymentEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItemEntity> items;

    @Enumerated(EnumType.STRING)
    private OrderState state;

    @DecimalMin("0.00")
    @JoinColumn(name = "total_price")
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "payment_confirmation_status")
    private PaymentConfirmationStatus paymentConfirmationStatus;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "payment_id")
    private PaymentEntity payment;

}
