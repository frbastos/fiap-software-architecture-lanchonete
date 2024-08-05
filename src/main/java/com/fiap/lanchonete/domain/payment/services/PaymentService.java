package com.fiap.lanchonete.domain.payment.services;


import com.fiap.lanchonete.domain.payment.Payment;
import com.fiap.lanchonete.domain.payment.dtos.PaymentResponse;
import com.fiap.lanchonete.domain.payment.ports.PaymentRepositoryPort;
import com.fiap.lanchonete.domain.payment.ports.PaymentServicePort;

public class PaymentService implements PaymentServicePort {

    public PaymentService(PaymentRepositoryPort paymentRepositoryPort) {
    }

    @Override
    public PaymentResponse save(Payment payment) {
        return null;
    }
}
