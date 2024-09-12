package com.fiap.lanchonete.infrastructure.payment.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiap.lanchonete.application.payment.gateways.PaymentGateway;
import com.fiap.lanchonete.application.payment.usecases.CreatePaymentUseCase;
import com.fiap.lanchonete.application.payment.usecases.CreatePaymentUseCaseImpl;
import com.fiap.lanchonete.infrastructure.payment.gateways.PaymentRepositoryGateway;
import com.fiap.lanchonete.infrastructure.payment.gateways.mappers.PaymentEntityMapper;
import com.fiap.lanchonete.infrastructure.payment.persistence.PaymentRepository;

@Configuration
public class BeanConfigurationPayment {

    @Bean
    PaymentGateway paymentGateway(PaymentRepository paymentRepository, PaymentEntityMapper paymentEntityMapper){
        return new PaymentRepositoryGateway(paymentRepository, paymentEntityMapper);
    }

    @Bean
    CreatePaymentUseCase createPaymentUseCase(PaymentGateway paymentRepository) {
        return new CreatePaymentUseCaseImpl(paymentRepository);
    }

    @Bean
    PaymentEntityMapper paymentEntityMapper(){
        return new PaymentEntityMapper();
    }
}