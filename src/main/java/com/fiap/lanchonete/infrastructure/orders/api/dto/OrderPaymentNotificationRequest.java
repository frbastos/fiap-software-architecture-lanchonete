package com.fiap.lanchonete.infrastructure.orders.api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fiap.lanchonete.domain.payment.valueobjects.PaymentStatus;

import jakarta.validation.constraints.NotNull;

public record OrderPaymentNotificationRequest(
    @NotNull Long orderId,
    BigDecimal amount,
    LocalDateTime time,
    String transactionId,
    @NotNull PaymentStatus paymentStatus
) {

}
