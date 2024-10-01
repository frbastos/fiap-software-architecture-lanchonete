package com.fiap.lanchonete.application.payment.usecases.command;

import java.math.BigDecimal;

public record SendPaymentCommand(
    Long orderId,
    BigDecimal amount
) {

}
