package com.fiap.lanchonete.infrastructure.payment.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fiap.lanchonete.application.payment.gateways.PaymentGateway;
import com.fiap.lanchonete.application.payment.gateways.PaymentProcessorGateway;
import com.fiap.lanchonete.application.payment.usecases.CreatePaymentUseCase;
import com.fiap.lanchonete.application.payment.usecases.CreatePaymentUseCaseImpl;
import com.fiap.lanchonete.application.payment.usecases.ProcessPaymentMockUseCase;
import com.fiap.lanchonete.application.payment.usecases.ProcessPaymentMockUseCaseImpl;
import com.fiap.lanchonete.application.payment.usecases.SendQRCODEPaymentToThirdPartyUseCase;
import com.fiap.lanchonete.application.payment.usecases.SendQRCODEPaymentToThirdPartyUseCaseImpl;
import com.fiap.lanchonete.infrastructure.payment.api.dto.PaymentCommandMapper;
import com.fiap.lanchonete.infrastructure.payment.gateways.MockProcessorGateway;
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
    
    @Bean
    PaymentProcessorGateway paymentProcessorGateway(RestTemplate restTemplate){
        String webhookUrl = "http://localhost:8080/orders/webhook/payments";
        return new MockProcessorGateway(webhookUrl, restTemplate);
    }

    @Bean
    PaymentCommandMapper paymentCommandMapper(){
        return new PaymentCommandMapper();
    }

    @Bean
    SendQRCODEPaymentToThirdPartyUseCase sendQRCODEPaymentToThirdPartyUseCase(){
        return new SendQRCODEPaymentToThirdPartyUseCaseImpl();
    }

    @Bean
    ProcessPaymentMockUseCase processPaymentMockUseCase(PaymentProcessorGateway paymentProcessorGateway){
        return new ProcessPaymentMockUseCaseImpl(paymentProcessorGateway);
    }
}