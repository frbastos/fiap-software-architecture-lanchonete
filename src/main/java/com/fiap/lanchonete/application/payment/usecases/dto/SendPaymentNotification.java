package com.fiap.lanchonete.application.payment.usecases.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fiap.lanchonete.domain.payment.valueobjects.PaymentStatus;

public record SendPaymentNotification(
    Long orderId,
    BigDecimal amount,
    LocalDateTime time,
    Long transactionId,
    PaymentStatus paymentStatus
) {

}
