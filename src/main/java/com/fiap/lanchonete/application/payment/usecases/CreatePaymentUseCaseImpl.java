package com.fiap.lanchonete.application.payment.usecases;

import com.fiap.lanchonete.application.payment.gateways.PaymentGateway;
import com.fiap.lanchonete.application.payment.usecases.command.CreatePaymentCommand;
import com.fiap.lanchonete.domain.payment.entities.Payment;

public class CreatePaymentUseCaseImpl implements CreatePaymentUseCase {

    private final PaymentGateway paymentGateway;

    public CreatePaymentUseCaseImpl(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public Payment createPayment(CreatePaymentCommand command){
        Payment payment = new Payment(null, command.time(), command.amount(), command.transactionId(), command.status());
        return paymentGateway.createPayment(payment);
    }
}
