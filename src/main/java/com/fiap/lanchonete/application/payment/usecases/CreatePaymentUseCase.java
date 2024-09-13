package com.fiap.lanchonete.application.payment.usecases;

import com.fiap.lanchonete.application.payment.usecases.command.CreatePaymentCommand;
import com.fiap.lanchonete.domain.payment.entities.Payment;

public interface CreatePaymentUseCase {

    Payment createPayment(CreatePaymentCommand createPaymentCommand);

}
