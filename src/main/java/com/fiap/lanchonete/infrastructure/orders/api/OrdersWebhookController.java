package com.fiap.lanchonete.infrastructure.orders.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.lanchonete.application.orders.usecases.OrderPaymentProcessorUseCase;
import com.fiap.lanchonete.application.orders.usecases.command.OrderPaymentNotificationCommand;
import com.fiap.lanchonete.infrastructure.orders.api.dto.OrderCommandMapper;
import com.fiap.lanchonete.infrastructure.orders.api.dto.OrderPaymentNotificationRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders/webhook")
public class OrdersWebhookController {

    private final OrderPaymentProcessorUseCase orderPaymentProcessorUseCase;
    private final OrderCommandMapper orderCommandMapper;

    public OrdersWebhookController(
            OrderPaymentProcessorUseCase orderPaymentProcessorUseCase,
            OrderCommandMapper orderCommandMapper) {

        this.orderPaymentProcessorUseCase = orderPaymentProcessorUseCase;
        this.orderCommandMapper = orderCommandMapper;
    }

    @PostMapping("/payments")
    public ResponseEntity<?> handlePaymentsNotification(
            @Valid @RequestBody OrderPaymentNotificationRequest orderPaymentNotification) {

        OrderPaymentNotificationCommand orderPaymentoCommand = orderCommandMapper
                .toOrderPaymentNotificationCommand(orderPaymentNotification);

        orderPaymentProcessorUseCase.process(orderPaymentoCommand);

        return ResponseEntity.ok().build();
    }

}
