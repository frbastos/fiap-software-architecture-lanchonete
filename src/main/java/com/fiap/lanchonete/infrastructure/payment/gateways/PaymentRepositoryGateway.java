package com.fiap.lanchonete.infrastructure.payment.gateways;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiap.lanchonete.application.payment.gateways.PaymentGateway;
import com.fiap.lanchonete.domain.payment.entities.Payment;
import com.fiap.lanchonete.infrastructure.payment.persistence.PaymentEntity;
import com.fiap.lanchonete.infrastructure.payment.persistence.PaymentRepository;

@Component
public class PaymentRepositoryGateway implements PaymentGateway {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment createPayment(Payment payment) {
        PaymentEntity paymentEntity = new PaymentEntity(payment);
        paymentEntity = this.paymentRepository.save(paymentEntity);
        return paymentEntity.toPayment();
    }
}
