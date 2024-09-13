package com.fiap.lanchonete.application.payment.usecases.command;

import java.math.BigDecimal;
import java.util.UUID;

public record ProcessPaymentMockCommand(
    UUID orderId,
    BigDecimal amount
) {

}
