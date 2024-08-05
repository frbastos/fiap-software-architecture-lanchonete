package com.fiap.lanchonete.domain.payment.ports;


import com.fiap.lanchonete.domain.payment.Payment;
import com.fiap.lanchonete.domain.payment.dtos.PaymentResponse;

public interface PaymentServicePort {

    //Fazer o payment persistence quando tiver Order
    PaymentResponse save(Payment payment);
}
