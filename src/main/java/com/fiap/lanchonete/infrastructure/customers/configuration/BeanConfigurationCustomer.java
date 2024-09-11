package com.fiap.lanchonete.infrastructure.customers.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiap.lanchonete.application.customers.gateways.CustomerGateway;
import com.fiap.lanchonete.application.customers.usecases.FindCustomerUseCaseImpl;
import com.fiap.lanchonete.application.customers.usecases.RegisterCustomerUseCaseImpl;
import com.fiap.lanchonete.infrastructure.customers.api.dto.CustomerDTOMapper;
import com.fiap.lanchonete.infrastructure.customers.gateway.mappers.CustomerEntityMapper;

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

    @Bean
    CustomerDTOMapper customerDTOMapper(){
        return new CustomerDTOMapper();
    }

    @Bean
    CustomerEntityMapper customerEntityMapper(){
        return new CustomerEntityMapper();
    }
}
