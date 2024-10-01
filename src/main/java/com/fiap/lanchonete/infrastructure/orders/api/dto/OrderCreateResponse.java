package com.fiap.lanchonete.infrastructure.orders.api.dto;

import com.fiap.lanchonete.domain.orders.valueobjects.OrderState;
import com.fiap.lanchonete.domain.orders.valueobjects.PaymentConfirmationStatus;
import com.fiap.lanchonete.infrastructure.customers.api.dto.CustomerResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record OrderCreateResponse(
        Long orderNumber) {

}
