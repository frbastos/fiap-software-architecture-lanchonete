package com.fiap.lanchonete.infrastructure.adapters.payment.entity;

import com.fiap.lanchonete.domain.payment.models.Payment;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="payment")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    private BigDecimal price;
    @NotNull
    private LocalDateTime time;

    @NotNull
    private UUID idOder;

    public PaymentEntity(Payment payment) {
        this.id = payment.getId();
        this.time = payment.getTime();
        this.price = payment.getPrice();
        this.idOder = payment.getIdOrder();
    }

    public Payment toPayment() { return new Payment(this.id,this.price, this.time,this.idOder);
    }

    @PrePersist
    public void prePersist(){
        this.time = LocalDateTime.now();
    }




}
