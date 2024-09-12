package com.fiap.lanchonete.application.payment.usecases;

import com.fiap.lanchonete.domain.payment.entities.Payment;
import com.fiap.lanchonete.domain.payment.entities.PaymentPersistence;

public interface CreatePaymentUseCase {

    Payment createPayment(PaymentPersistence persistence);

}
