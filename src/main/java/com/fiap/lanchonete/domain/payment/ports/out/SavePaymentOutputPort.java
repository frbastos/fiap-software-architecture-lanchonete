package com.fiap.lanchonete.domain.payment.ports.out;

import com.fiap.lanchonete.domain.payment.models.Payment;

public interface SavePaymentOutputPort {

    Payment save(Payment payment);
}
