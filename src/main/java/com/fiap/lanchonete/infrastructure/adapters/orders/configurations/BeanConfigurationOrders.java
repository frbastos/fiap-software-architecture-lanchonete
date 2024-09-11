package com.fiap.lanchonete.infrastructure.adapters.orders.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiap.lanchonete.application.customers.gateways.FindCustomerOutputPort;
import com.fiap.lanchonete.application.payment.usecases.CreatePaymentUseCase;
import com.fiap.lanchonete.application.products.gateways.GetProductByIdGateway;
import com.fiap.lanchonete.domain.orders.ports.out.GetAllOrdersOutputPort;
import com.fiap.lanchonete.domain.orders.ports.out.GetOrderByIdOutputPort;
import com.fiap.lanchonete.domain.orders.ports.out.SaveOrderOutputPort;
import com.fiap.lanchonete.domain.orders.usecases.CreateOrderUseCase;
import com.fiap.lanchonete.domain.orders.usecases.GetAllOrdersUseCase;
import com.fiap.lanchonete.domain.orders.usecases.GetOrderByIdUseCase;
import com.fiap.lanchonete.domain.orders.usecases.UpdateOrderStateUseCase;

@Configuration
public class BeanConfigurationOrders {

    @Bean
    public CreateOrderUseCase createOrderUseCase(
            SaveOrderOutputPort ordersRepository,
            CreatePaymentUseCase createPaymentInputPort,
            GetProductByIdGateway getProductByIdOutputPort,
            FindCustomerOutputPort findCustomerOutputPort
    ) {
        return new CreateOrderUseCase(ordersRepository, createPaymentInputPort, getProductByIdOutputPort, findCustomerOutputPort);
    }

    @Bean
    public GetAllOrdersUseCase getAllOrdersUseCase(
            GetAllOrdersOutputPort ordersRepository
    ) {
        return new GetAllOrdersUseCase(ordersRepository);
    }

    @Bean
    public GetOrderByIdUseCase getOrderByIdUseCase(
            GetOrderByIdOutputPort ordersRepository
    ) {
        return new GetOrderByIdUseCase(ordersRepository);
    }

    @Bean
    public UpdateOrderStateUseCase updateOrderStateUseCase(
            GetOrderByIdOutputPort getOrderByIdRepository,
            SaveOrderOutputPort saveOrderOutputPort
    ) {
        return new UpdateOrderStateUseCase(getOrderByIdRepository, saveOrderOutputPort);
    }

}
