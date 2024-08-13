package com.fiap.lanchonete.domain.payment.ports.out;

import com.fiap.lanchonete.domain.payment.models.Payment;

public interface CreatePaymentOutputPort {

    Payment createPayment(Payment payment);
}
