package com.fiap.lanchonete.infrastructure.adapters.payment.repository;


import com.fiap.lanchonete.domain.payment.Payment;
import com.fiap.lanchonete.domain.payment.ports.PaymentRepositoryPort;
import com.fiap.lanchonete.infrastructure.adapters.payment.entity.PaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentRepositoryImpl implements PaymentRepositoryPort {

    @Autowired
    private PaymentRepository paymentRepository;


    public Payment save(Payment payment){
        PaymentEntity paymentEntity = new PaymentEntity(payment);
        paymentEntity = this.paymentRepository.save(paymentEntity);
        return paymentEntity.toPayment();
    }

}
