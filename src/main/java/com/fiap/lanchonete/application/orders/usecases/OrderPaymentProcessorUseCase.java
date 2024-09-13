package com.fiap.lanchonete.application.orders.usecases;

import com.fiap.lanchonete.application.orders.usecases.command.OrderPaymentNotificationCommand;

public interface OrderPaymentProcessorUseCase {

    void process(OrderPaymentNotificationCommand orderPaymentNotificationCommand);

}
