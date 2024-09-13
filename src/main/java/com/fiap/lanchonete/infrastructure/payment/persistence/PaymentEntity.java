package com.fiap.lanchonete.infrastructure.payment.persistence;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fiap.lanchonete.domain.payment.valueobjects.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    private LocalDateTime time;

    @NotNull
    private BigDecimal amount;
    
    @NotNull
    @JoinColumn(name = "transaction_id")
    private String transactionId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
   
}
