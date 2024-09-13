package com.fiap.lanchonete.application.payment.gateways;

import com.fiap.lanchonete.application.payment.usecases.dto.SendPaymentNotification;

public interface PaymentProcessorGateway {

    void sendNotification(SendPaymentNotification sendPaymentNotification);

}
