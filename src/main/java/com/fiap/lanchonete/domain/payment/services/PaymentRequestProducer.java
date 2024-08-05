package com.fiap.lanchonete.domain.payment.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.lanchonete.domain.payment.dtos.PaymentPersistence;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentRequestProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void integrar(PaymentPersistence payment) throws JsonProcessingException {
        amqpTemplate.convertAndSend(
                "payment-request-exchange",
                "payment-request-route-key",
                objectMapper.writeValueAsString(payment)

        );
    }
}
