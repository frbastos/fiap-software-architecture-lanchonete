package com.fiap.lanchonete.infrastructure.payment.gateways;

import com.fiap.lanchonete.application.payment.gateways.PaymentGateway;
import com.fiap.lanchonete.domain.payment.entities.Payment;
import com.fiap.lanchonete.infrastructure.payment.gateways.mappers.PaymentEntityMapper;
import com.fiap.lanchonete.infrastructure.payment.persistence.PaymentEntity;
import com.fiap.lanchonete.infrastructure.payment.persistence.PaymentRepository;

public class PaymentRepositoryGateway implements PaymentGateway {

    private PaymentRepository paymentRepository;
    private PaymentEntityMapper paymentEntityMapper;

    public PaymentRepositoryGateway(PaymentRepository paymentRepository, PaymentEntityMapper paymentEntityMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentEntityMapper = paymentEntityMapper;
    }

    public Payment createPayment(Payment payment) {
        PaymentEntity entity = this.paymentRepository.save(paymentEntityMapper.toEntity(payment));
        return paymentEntityMapper.toPayment(entity);
    }
}
