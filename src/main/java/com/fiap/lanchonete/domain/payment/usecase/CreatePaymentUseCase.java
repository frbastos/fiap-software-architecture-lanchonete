package com.fiap.lanchonete.domain.payment.usecase;

import com.fiap.lanchonete.domain.payment.models.Payment;
import com.fiap.lanchonete.domain.payment.models.PaymentPersistence;
import com.fiap.lanchonete.domain.payment.ports.in.CreatePaymentInputPort;
import com.fiap.lanchonete.domain.payment.ports.out.CreatePaymentOutputPort;

public class CreatePaymentUseCase implements CreatePaymentInputPort {

    private final CreatePaymentOutputPort savePaymentOutputPort;

    public CreatePaymentUseCase(CreatePaymentOutputPort savePaymentOutputPort) {
        this.savePaymentOutputPort = savePaymentOutputPort;
    }

    @Override
    public Payment createPayment(PaymentPersistence persistence) {
        Payment payment = new Payment(persistence.price(), persistence.idOrder());
        return this.savePaymentOutputPort.createPayment(payment);
    }
}
