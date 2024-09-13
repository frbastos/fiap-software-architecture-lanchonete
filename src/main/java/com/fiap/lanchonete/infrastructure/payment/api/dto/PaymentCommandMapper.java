package com.fiap.lanchonete.infrastructure.payment.api.dto;

import com.fiap.lanchonete.application.payment.usecases.command.ProcessPaymentMockCommand;

public class PaymentCommandMapper {

    public ProcessPaymentMockCommand toProcessPaymentMockCommand(PaymentRequest paymentRequest){
        return new ProcessPaymentMockCommand(paymentRequest.orderId(), paymentRequest.amount());
    }

}
