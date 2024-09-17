package com.fiap.lanchonete.infrastructure.orders.api.dto;

import com.fiap.lanchonete.domain.orders.valueobjects.PaymentConfirmationStatus;

public record OrderStatusPaymentResponse(
        Long orderNumber,
        PaymentConfirmationStatus paymentConfirmationStatus) {

}
