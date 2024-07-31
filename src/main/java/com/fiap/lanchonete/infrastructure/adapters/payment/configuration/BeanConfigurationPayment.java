package com.fiap.lanchonete.infrastructure.adapters.payment.configuration;

import com.fiap.lanchonete.domain.customers.ports.CustomerRepositoryPort;
import com.fiap.lanchonete.domain.customers.ports.CustomerServicePort;
import com.fiap.lanchonete.domain.customers.services.CustomerService;
import com.fiap.lanchonete.domain.payment.ports.PaymentRepositoryPort;
import com.fiap.lanchonete.domain.payment.ports.PaymentServicePort;
import com.fiap.lanchonete.domain.payment.services.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurationPayment {

    @Bean
    PaymentServicePort paymentServicePort(PaymentRepositoryPort paymentRepositoryPort){return new PaymentService(paymentRepositoryPort);}
}
