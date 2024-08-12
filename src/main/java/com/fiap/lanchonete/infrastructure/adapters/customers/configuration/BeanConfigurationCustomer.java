package com.fiap.lanchonete.infrastructure.adapters.customers.configuration;

import com.fiap.lanchonete.domain.customers.ports.out.FindCustomerOutputPort;
import com.fiap.lanchonete.domain.customers.ports.out.RegisterCustomerOutputPort;
import com.fiap.lanchonete.domain.customers.usecase.FindCustomerUseCase;
import com.fiap.lanchonete.domain.customers.usecase.RegisterCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurationCustomer {

    @Bean
    FindCustomerUseCase findCustomerUseCase(FindCustomerOutputPort findCustomerOutputPort){return new FindCustomerUseCase(findCustomerOutputPort);}

    @Bean
    RegisterCustomerUseCase registerCustomerUseCase(RegisterCustomerOutputPort registerCustomerOutputPort){return new RegisterCustomerUseCase(registerCustomerOutputPort);}
}
