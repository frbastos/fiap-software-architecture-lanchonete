package com.fiap.lanchonete.infrastructure.customers.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiap.lanchonete.application.customers.gateways.CustomerGateway;
import com.fiap.lanchonete.application.customers.usecases.FindCustomerUseCaseImpl;
import com.fiap.lanchonete.application.customers.usecases.RegisterCustomerUseCaseImpl;

@Configuration
public class BeanConfigurationCustomer {

    @Bean
    FindCustomerUseCaseImpl findCustomerUseCase(CustomerGateway customerGateway) {
        return new FindCustomerUseCaseImpl(customerGateway);
    }

    @Bean
    RegisterCustomerUseCaseImpl registerCustomerUseCase(CustomerGateway customerGateway) {
        return new RegisterCustomerUseCaseImpl(customerGateway);
    }
}
