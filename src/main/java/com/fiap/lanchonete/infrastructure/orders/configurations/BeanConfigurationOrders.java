package com.fiap.lanchonete.infrastructure.orders.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiap.lanchonete.application.customers.usecases.FindCustomerUseCase;
import com.fiap.lanchonete.application.orders.gateways.OrderGateway;
import com.fiap.lanchonete.application.orders.usecases.CreateOrderUseCaseImpl;
import com.fiap.lanchonete.application.orders.usecases.GetAllOrdersUseCaseImpl;
import com.fiap.lanchonete.application.orders.usecases.GetOrderByIdUseCaseImpl;
import com.fiap.lanchonete.application.orders.usecases.UpdateOrderStateUseCaseImpl;
import com.fiap.lanchonete.application.payment.usecases.CreatePaymentUseCase;
import com.fiap.lanchonete.application.products.usecases.GetProductByIdUseCase;

@Configuration
public class BeanConfigurationOrders {

    @Bean
    public CreateOrderUseCaseImpl createOrderUseCase(
            OrderGateway orderGateway,
            CreatePaymentUseCase createPaymentUseCase,
            GetProductByIdUseCase getProductByIdUseCase,
            FindCustomerUseCase findCustomerUseCase) {
        return new CreateOrderUseCaseImpl(orderGateway, createPaymentUseCase, findCustomerUseCase,
                getProductByIdUseCase);
    }

    @Bean
    public GetAllOrdersUseCaseImpl getAllOrdersUseCase(
            OrderGateway orderGateway) {
        return new GetAllOrdersUseCaseImpl(orderGateway);
    }

    @Bean
    public GetOrderByIdUseCaseImpl getOrderByIdUseCase(
            OrderGateway orderGateway) {
        return new GetOrderByIdUseCaseImpl(orderGateway);
    }

    @Bean
    public UpdateOrderStateUseCaseImpl updateOrderStateUseCase(
            OrderGateway orderGateway) {
        return new UpdateOrderStateUseCaseImpl(orderGateway);
    }

}
