package com.fiap.lanchonete.infrastructure.adapters.customers.configuration;

import com.fiap.lanchonete.domain.customers.ports.CustomerRepositoryPort;
import com.fiap.lanchonete.domain.customers.ports.CustomerServicePort;
import com.fiap.lanchonete.domain.customers.service.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurationCustomer {

    @Bean
    CustomerServicePort customerServicePort(CustomerRepositoryPort customerRepositoryPort){return new CustomerService(customerRepositoryPort);}
}
