package com.fiap.lanchonete.infrastructure.orders.api.dto;

import com.fiap.lanchonete.application.orders.usecases.command.OrderPaymentNotificationCommand;
import com.fiap.lanchonete.application.payment.usecases.command.SendPaymentCommand;
import com.fiap.lanchonete.domain.orders.entities.Order;

public class OrderCommandMapper {

    public OrderPaymentNotificationCommand toOrderPaymentNotificationCommand(OrderPaymentNotificationRequest request) {
        return new OrderPaymentNotificationCommand(request.orderId(), request.amount(), request.time(), request.transactionId(), request.paymentStatus());
    }

    public SendPaymentCommand toSendPaymentQRCODECommand(Order order){
        return new SendPaymentCommand(order.getId(), order.getTotalPrice());
    }

}
