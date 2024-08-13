package com.fiap.lanchonete.application.payment.adapters.api;

import com.fiap.lanchonete.domain.payment.models.Payment;
import com.fiap.lanchonete.domain.payment.models.PaymentPersistence;
import com.fiap.lanchonete.domain.payment.ports.in.CreatePaymentInputPort;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentApi {

    private final CreatePaymentInputPort paymentService;

    public PaymentApi(CreatePaymentInputPort paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("")
    public Payment savePayment(@Valid @RequestBody PaymentPersistence persistence){
        return this.paymentService.createPayment(persistence);
    }

}
