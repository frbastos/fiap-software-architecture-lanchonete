package com.fiap.lanchonete.infrastructure.payment.api.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public record PaymentRequest(
    @NotNull Long orderId,
    BigDecimal amount
) {

}
