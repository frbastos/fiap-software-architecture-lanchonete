package com.fiap.lanchonete.domain.payment.entities;

import java.math.BigDecimal;

public record PaymentPersistence(BigDecimal price, Long idOrder) {
}