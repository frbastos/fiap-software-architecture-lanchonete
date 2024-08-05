package com.fiap.lanchonete.domain.payment.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fiap.lanchonete.domain.payment.dtos.PaymentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentFacade {

    @Autowired
    private PaymentRequestProducer producer;

    public String requestPayment(PaymentPersistence request) {
        try {
            producer.integrar(request);
        } catch (JsonProcessingException e) {
            return " Ocorreu um erro : " + e.getMessage();
        }
        return "Pagamento na fila";
    }
}
