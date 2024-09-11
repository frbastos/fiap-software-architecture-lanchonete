package com.fiap.lanchonete.infrastructure.payment.persistence;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fiap.lanchonete.domain.payment.entities.Payment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
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

    public Payment toPayment() {
        return new Payment(this.id, this.price, this.time, this.idOder);
    }

    @PrePersist
    public void prePersist() {
        this.time = LocalDateTime.now();
    }

}
