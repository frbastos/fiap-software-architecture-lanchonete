package com.fiap.lanchonete.application.payment.adapters.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fiap.lanchonete.domain.payment.services.PaymentFacade;
import com.fiap.lanchonete.domain.payment.dtos.PaymentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentResource {

    @Autowired
    private PaymentFacade paymentFacade;

    @PostMapping
    public String sendPaymentToQueue(@RequestBody PaymentPersistence request) throws JsonProcessingException {
        return paymentFacade.requestPayment(request);
    }
}
