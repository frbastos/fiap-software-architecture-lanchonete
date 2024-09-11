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
import com.fiap.lanchonete.infrastructure.customers.gateway.mappers.CustomerEntityMapper;
import com.fiap.lanchonete.infrastructure.orders.gateways.OrdersRepositoryGateways;
import com.fiap.lanchonete.infrastructure.orders.gateways.mappers.OrderEntityMapper;
import com.fiap.lanchonete.infrastructure.orders.gateways.mappers.OrderItemEntityMapper;
import com.fiap.lanchonete.infrastructure.orders.persistence.OrdersRepository;
import com.fiap.lanchonete.infrastructure.products.gateways.mappers.ProductEntityMapper;

@Configuration
public class BeanConfigurationOrders {

    @Bean
    OrderGateway orderGateway(OrdersRepository ordersRepository, OrderEntityMapper orderEntityMapper){
        return new OrdersRepositoryGateways(ordersRepository, orderEntityMapper);
    }

    @Bean
    CreateOrderUseCaseImpl createOrderUseCase(
            OrderGateway orderGateway,
            CreatePaymentUseCase createPaymentUseCase,
            GetProductByIdUseCase getProductByIdUseCase,
            FindCustomerUseCase findCustomerUseCase) {
        return new CreateOrderUseCaseImpl(orderGateway, createPaymentUseCase, findCustomerUseCase,
                getProductByIdUseCase);
    }

    @Bean
    GetAllOrdersUseCaseImpl getAllOrdersUseCase(
            OrderGateway orderGateway) {
        return new GetAllOrdersUseCaseImpl(orderGateway);
    }

    @Bean
    GetOrderByIdUseCaseImpl getOrderByIdUseCase(
            OrderGateway orderGateway) {
        return new GetOrderByIdUseCaseImpl(orderGateway);
    }

    @Bean
    UpdateOrderStateUseCaseImpl updateOrderStateUseCase(
            OrderGateway orderGateway) {
        return new UpdateOrderStateUseCaseImpl(orderGateway);
    }

    @Bean
    OrderEntityMapper orderEntityMapper(CustomerEntityMapper customerEntityMapper, OrderItemEntityMapper orderItemEntityMapper){
        return new OrderEntityMapper(customerEntityMapper, orderItemEntityMapper);
    }

    @Bean
    OrderItemEntityMapper orderItemEntityMapper(ProductEntityMapper productEntityMapper){
        return new OrderItemEntityMapper(productEntityMapper);
    }

}
