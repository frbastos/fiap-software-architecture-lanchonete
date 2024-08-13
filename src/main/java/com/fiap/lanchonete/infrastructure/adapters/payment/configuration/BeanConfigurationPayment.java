package com.fiap.lanchonete.infrastructure.adapters.payment.configuration;

import com.fiap.lanchonete.domain.payment.ports.out.CreatePaymentOutputPort;
import com.fiap.lanchonete.domain.payment.usecase.CreatePaymentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurationPayment {

    @Bean
    CreatePaymentUseCase createPaymentUseCase(CreatePaymentOutputPort paymentRepository) {
        return new CreatePaymentUseCase(paymentRepository);
    }
}