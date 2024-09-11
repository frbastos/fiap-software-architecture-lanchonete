package com.fiap.lanchonete.application.payment.usecases;

import com.fiap.lanchonete.application.payment.gateways.PaymentGateway;
import com.fiap.lanchonete.domain.payment.entities.Payment;
import com.fiap.lanchonete.domain.payment.entities.PaymentPersistence;

public class CreatePaymentUseCaseImpl implements CreatePaymentUseCase {

    private final PaymentGateway paymentGateway;

    public CreatePaymentUseCaseImpl(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public Payment createPayment(PaymentPersistence persistence) {
        Payment payment = new Payment(persistence.price(), persistence.idOrder());
        return this.paymentGateway.createPayment(payment);
    }
}
