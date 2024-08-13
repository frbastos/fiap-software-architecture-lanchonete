package com.fiap.lanchonete.infrastructure.adapters.payment.repository;

import com.fiap.lanchonete.domain.payment.models.Payment;
import com.fiap.lanchonete.domain.payment.ports.out.CreatePaymentOutputPort;
import com.fiap.lanchonete.infrastructure.adapters.payment.entity.PaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentRepositoryImplOutput implements CreatePaymentOutputPort {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment createPayment(Payment payment) {
        PaymentEntity paymentEntity = new PaymentEntity(payment);
        paymentEntity = this.paymentRepository.save(paymentEntity);
        return paymentEntity.toPayment();
    }
}
