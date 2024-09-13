package com.fiap.lanchonete.application.payment.usecases;

import com.fiap.lanchonete.application.payment.usecases.command.ProcessPaymentMockCommand;

public interface ProcessPaymentMockUseCase {

    void process(ProcessPaymentMockCommand processPaymentMockCommand);

}
