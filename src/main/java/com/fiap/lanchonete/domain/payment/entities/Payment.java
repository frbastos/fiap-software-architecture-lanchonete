package com.fiap.lanchonete.domain.payment.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fiap.lanchonete.domain.payment.valueobjects.PaymentStatus;

public record Payment (
    UUID id,
    LocalDateTime time,
    BigDecimal amount,
    String transactionId,
    PaymentStatus status
){
    public boolean isApproved(){
        return status.equals(PaymentStatus.APPROVED);
    }
}