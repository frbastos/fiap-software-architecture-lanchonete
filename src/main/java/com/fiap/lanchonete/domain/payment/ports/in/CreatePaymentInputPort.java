package com.fiap.lanchonete.domain.payment.ports.in;

import com.fiap.lanchonete.domain.payment.models.Payment;
import com.fiap.lanchonete.domain.payment.models.PaymentPersistence;

public interface CreatePaymentInputPort {

    Payment createPayment(PaymentPersistence payment);


}
