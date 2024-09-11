package com.fiap.lanchonete.infrastructure.payment.gateways.mappers;

import com.fiap.lanchonete.domain.payment.entities.Payment;
import com.fiap.lanchonete.infrastructure.payment.persistence.PaymentEntity;

public class PaymentEntityMapper {

    public Payment toPayment(PaymentEntity entity){
        return new Payment(entity.getId(), entity.getPrice(), entity.getTime(), entity.getIdOder());
    }

    public PaymentEntity toEntity(Payment payment){
        return new PaymentEntity(payment.getId(), payment.getPrice(), payment.getTime(), payment.getIdOrder());
    }

}
