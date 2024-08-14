package com.fiap.lanchonete.domain.orders.usecases;

import com.fiap.lanchonete.domain.orders.models.Order;
import com.fiap.lanchonete.domain.orders.models.OrderPersistence;
import com.fiap.lanchonete.domain.orders.ports.in.CreateOrderInputPort;
import com.fiap.lanchonete.domain.orders.ports.out.SaveOrderOutputPort;
import com.fiap.lanchonete.domain.payment.models.PaymentPersistence;
import com.fiap.lanchonete.domain.payment.ports.in.CreatePaymentInputPort;

public class CreateOrderUseCase implements CreateOrderInputPort {

    private final SaveOrderOutputPort ordersRepository;

    private final CreatePaymentInputPort createPaymentInputPort;

    public CreateOrderUseCase(SaveOrderOutputPort ordersRepository, CreatePaymentInputPort createPaymentInputPort) {
        this.ordersRepository = ordersRepository;
        this.createPaymentInputPort =createPaymentInputPort;
    }

    @Override
    public void createOrder(OrderPersistence persistence) {
        Order order = new Order(persistence);
        this.ordersRepository.save(order);
        PaymentPersistence  paymentPersistence= new PaymentPersistence(order.getTotalPrice(),order.getId());
        this.createPaymentInputPort.createPayment(paymentPersistence);
    }

}
