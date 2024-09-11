package com.fiap.lanchonete.infrastructure.payment.api;

import org.springframework.web.bind.annotation.RestController;

import com.fiap.lanchonete.application.payment.usecases.CreatePaymentUseCase;
import com.fiap.lanchonete.domain.payment.entities.Payment;
import com.fiap.lanchonete.domain.payment.entities.PaymentPersistence;

@RestController
public class PaymentControler implements PaymentApi {

    private final CreatePaymentUseCase createPaymentUseCase;

    public PaymentControler(CreatePaymentUseCase createPaymentUseCase) {
        this.createPaymentUseCase = createPaymentUseCase;
    }

    @Override
    public Payment savePayment(PaymentPersistence persistence) {
        return createPaymentUseCase.createPayment(persistence);
    }

}
