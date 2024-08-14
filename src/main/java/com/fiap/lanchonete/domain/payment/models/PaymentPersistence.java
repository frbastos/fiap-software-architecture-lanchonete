package com.fiap.lanchonete.domain.payment.models;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentPersistence(BigDecimal price, UUID idOrder) {
}