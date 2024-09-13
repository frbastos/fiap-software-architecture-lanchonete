package com.fiap.lanchonete.application.orders.usecases.command;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fiap.lanchonete.domain.payment.valueobjects.PaymentStatus;

public record OrderPaymentNotificationCommand(
    UUID orderId,
    BigDecimal amount,
    LocalDateTime time,
    String transactionId,
    PaymentStatus paymentStatus
) {

}
