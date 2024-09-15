package com.fiap.lanchonete.application.payment.usecases;

import com.fiap.lanchonete.application.payment.usecases.command.ProcessPaymentMockCommand;
import com.fiap.lanchonete.application.payment.usecases.command.SendPaymentCommand;

public class SendQRCODEPaymentToThirdPartyUseCaseImpl implements SendQRCODEPaymentToThirdPartyUseCase {

    private final ProcessPaymentMockUseCase processPaymentMockUseCase;

    public SendQRCODEPaymentToThirdPartyUseCaseImpl(ProcessPaymentMockUseCase processPaymentMockUseCase) {
        this.processPaymentMockUseCase = processPaymentMockUseCase;
    }

    @Override
    public void send(SendPaymentCommand command) {
        ProcessPaymentMockCommand processPaymentMockCommand = new ProcessPaymentMockCommand(command.orderId(), command.amount());
        processPaymentMockUseCase.process(processPaymentMockCommand);
    }

}
