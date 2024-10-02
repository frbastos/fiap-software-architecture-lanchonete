package com.fiap.lanchonete.application.payment.usecases.command;

import java.math.BigDecimal;

public record ProcessPaymentMockCommand(
    Long orderId,
    BigDecimal amount
) {

}
