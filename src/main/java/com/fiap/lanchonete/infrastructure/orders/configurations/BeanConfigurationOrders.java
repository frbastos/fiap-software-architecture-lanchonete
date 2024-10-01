package com.fiap.lanchonete.infrastructure.orders.configurations;

import com.fiap.lanchonete.application.orders.usecases.*;
import com.fiap.lanchonete.infrastructure.orders.api.dto.OrderGroupedMapper;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiap.lanchonete.application.customers.usecases.FindCustomerUseCase;
import com.fiap.lanchonete.application.orders.gateways.OrderGateway;
import com.fiap.lanchonete.application.payment.usecases.CreatePaymentUseCase;
import com.fiap.lanchonete.application.products.usecases.GetProductByIdUseCase;
import com.fiap.lanchonete.infrastructure.customers.api.dto.CustomerDTOMapper;
import com.fiap.lanchonete.infrastructure.customers.gateway.mappers.CustomerEntityMapper;
import com.fiap.lanchonete.infrastructure.orders.api.dto.OrderCommandMapper;
import com.fiap.lanchonete.infrastructure.orders.api.dto.OrderDTOMapper;
import com.fiap.lanchonete.infrastructure.orders.gateways.OrdersRepositoryGateways;
import com.fiap.lanchonete.infrastructure.orders.gateways.mappers.OrderEntityMapper;
import com.fiap.lanchonete.infrastructure.orders.gateways.mappers.OrderItemEntityMapper;
import com.fiap.lanchonete.infrastructure.orders.persistence.OrdersRepository;
import com.fiap.lanchonete.infrastructure.payment.gateways.mappers.PaymentEntityMapper;
import com.fiap.lanchonete.infrastructure.products.gateways.mappers.ProductEntityMapper;

@Configuration
public class BeanConfigurationOrders {

    @Bean
    OrderGateway orderGateway(OrdersRepository ordersRepository, OrderEntityMapper orderEntityMapper) {
        return new OrdersRepositoryGateways(ordersRepository, orderEntityMapper);
    }

    @Bean
    CreateOrderUseCaseImpl createOrderUseCase(
            OrderGateway orderGateway,
            CreatePaymentUseCase createPaymentUseCase,
            GetProductByIdUseCase getProductByIdUseCase,
            FindCustomerUseCase findCustomerUseCase, EntityManager entityManager) {
        return new CreateOrderUseCaseImpl(orderGateway, createPaymentUseCase, findCustomerUseCase,
                getProductByIdUseCase, entityManager);
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
    OrderPaymentProcessorUseCase orderPaymentProcessorUseCase(OrderGateway orderGateway, GetOrderByIdUseCase getOrderByIdUseCase, CreatePaymentUseCase createPaymentUseCase) {
        return new OrderPaymentProcessorUseCaseImpl(orderGateway, getOrderByIdUseCase, createPaymentUseCase);
    }

    @Bean
    OrderEntityMapper orderEntityMapper(CustomerEntityMapper customerEntityMapper, OrderItemEntityMapper orderItemEntityMapper, PaymentEntityMapper paymentEntityMapper) {
        return new OrderEntityMapper(customerEntityMapper, orderItemEntityMapper, paymentEntityMapper);
    }

    @Bean
    OrderItemEntityMapper orderItemEntityMapper(ProductEntityMapper productEntityMapper) {
        return new OrderItemEntityMapper(productEntityMapper);
    }

    @Bean
    OrderCommandMapper orderCommandMapper() {
        return new OrderCommandMapper();
    }

    @Bean
    OrderDTOMapper orderDTOMapper(CustomerDTOMapper customerDTOMapper) {
        return new OrderDTOMapper(customerDTOMapper);
    }


    @Bean
    GetOrderByOrderNumberUseCaseImpl getOrderByOrderNumber(OrderGateway orderGateway){ return new GetOrderByOrderNumberUseCaseImpl(orderGateway);}

    @Bean
    OrderGroupedMapper orderGroupedMapper(){return new OrderGroupedMapper();}
}
