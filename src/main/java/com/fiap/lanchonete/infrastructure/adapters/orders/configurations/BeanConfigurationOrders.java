package com.fiap.lanchonete.infrastructure.adapters.orders.configurations;

import com.fiap.lanchonete.domain.orders.ports.out.GetAllOrdersOutputPort;
import com.fiap.lanchonete.domain.orders.ports.out.GetOrderByIdOutputPort;
import com.fiap.lanchonete.domain.orders.ports.out.SaveOrderOutputPort;
import com.fiap.lanchonete.domain.orders.usecases.CreateOrderUseCase;
import com.fiap.lanchonete.domain.orders.usecases.GetAllOrdersUseCase;
import com.fiap.lanchonete.domain.orders.usecases.GetOrderByIdUseCase;
import com.fiap.lanchonete.domain.orders.usecases.UpdateOrderStateUseCase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurationOrders {

    @Bean
    public CreateOrderUseCase createOrderUseCase(
            SaveOrderOutputPort ordersRepository
    ) {
        return new CreateOrderUseCase(ordersRepository);
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
