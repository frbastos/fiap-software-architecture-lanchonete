package com.fiap.lanchonete.application.payment.gateways;

import com.fiap.lanchonete.domain.payment.entities.Payment;

public interface PaymentGateway {

    Payment createPayment(Payment payment);
}
