package com.fiap.lanchonete.application.payment.usecases;

import com.fiap.lanchonete.application.payment.usecases.command.SendPaymentCommand;

public interface SendQRCODEPaymentToThirdPartyUseCase {

    void send(SendPaymentCommand sendPaymentCommand);
}
