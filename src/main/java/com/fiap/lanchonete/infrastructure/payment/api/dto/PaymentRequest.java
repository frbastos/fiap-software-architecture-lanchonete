package com.fiap.lanchonete.infrastructure.payment.api.dto;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record PaymentRequest(
    @NotNull UUID orderId,
    BigDecimal amount
) {

}
