package com.fiap.lanchonete.application.payment.usecases.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fiap.lanchonete.domain.payment.valueobjects.PaymentStatus;

public record SendPaymentNotification(
    UUID orderId,
    BigDecimal amount,
    LocalDateTime time,
    String transactionId,
    PaymentStatus paymentStatus
) {

}
