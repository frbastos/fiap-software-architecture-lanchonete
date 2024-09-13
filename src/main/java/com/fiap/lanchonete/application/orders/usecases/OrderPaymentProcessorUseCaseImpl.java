package com.fiap.lanchonete.application.orders.usecases;

import com.fiap.lanchonete.application.orders.gateways.OrderGateway;
import com.fiap.lanchonete.application.orders.usecases.command.OrderPaymentNotificationCommand;
import com.fiap.lanchonete.application.payment.usecases.CreatePaymentUseCase;
import com.fiap.lanchonete.application.payment.usecases.command.CreatePaymentCommand;
import com.fiap.lanchonete.domain.orders.entities.Order;
import com.fiap.lanchonete.domain.payment.entities.Payment;
import com.fiap.lanchonete.shared.exception.NotFoundException;

public class OrderPaymentProcessorUseCaseImpl implements OrderPaymentProcessorUseCase {

    private final OrderGateway orderGateway;
    private final GetOrderByIdUseCase getOrderByIdUseCase;
    private final CreatePaymentUseCase createPaymentUseCase;

    public OrderPaymentProcessorUseCaseImpl(
            OrderGateway orderGateway,
            GetOrderByIdUseCase getOrderByIdUseCase,
            CreatePaymentUseCase createPaymentUseCase) {

        this.orderGateway = orderGateway;
        this.getOrderByIdUseCase = getOrderByIdUseCase;
        this.createPaymentUseCase = createPaymentUseCase;
    }

    @Override
    public void process(OrderPaymentNotificationCommand command) {

        Order order = getOrderByIdUseCase.getOrderById(command.orderId())
                .orElseThrow(() -> new NotFoundException("Order not found with ID: " + command.orderId()));

        CreatePaymentCommand createPaymentCommand = new CreatePaymentCommand(command.time(), command.amount(), command.transactionId(), command.paymentStatus());

        Payment payment = createPaymentUseCase.createPayment(createPaymentCommand);
        order.processPayment(payment);

        orderGateway.save(order);
    }

}
