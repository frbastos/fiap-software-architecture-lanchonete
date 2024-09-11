package com.fiap.lanchonete.infrastructure.payment.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.lanchonete.application.payment.usecases.CreatePaymentUseCase;
import com.fiap.lanchonete.domain.payment.entities.Payment;
import com.fiap.lanchonete.domain.payment.entities.PaymentPersistence;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/payment")
public class PaymentControler {

    private final CreatePaymentUseCase createPaymentUseCase;

    public PaymentControler(CreatePaymentUseCase createPaymentUseCase) {
        this.createPaymentUseCase = createPaymentUseCase;
    }

    @PostMapping("")
    public Payment savePayment(@Valid @RequestBody PaymentPersistence persistence) {
        return createPaymentUseCase.createPayment(persistence);
    }

}
