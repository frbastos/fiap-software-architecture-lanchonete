package com.fiap.lanchonete.application.payment.usecases.command;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fiap.lanchonete.domain.payment.valueobjects.PaymentStatus;

public record CreatePaymentCommand(
    LocalDateTime time,
    BigDecimal amount,
    String transactionId,
    PaymentStatus status
) {}
