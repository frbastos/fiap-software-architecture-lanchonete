package com.fiap.lanchonete.infrastructure.orders.api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fiap.lanchonete.domain.orders.valueobjects.OrderState;
import com.fiap.lanchonete.domain.orders.valueobjects.PaymentConfirmationStatus;
import com.fiap.lanchonete.infrastructure.customers.api.dto.CustomerResponse;

public record OrderResponse(
        UUID id,
        LocalDateTime creationTime,
        CustomerResponse customer,
        OrderState state,
        BigDecimal totalPrice,
        PaymentConfirmationStatus paymentConfirmationStatus) {

}
