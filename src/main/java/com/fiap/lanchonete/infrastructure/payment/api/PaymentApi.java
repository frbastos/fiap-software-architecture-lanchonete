package com.fiap.lanchonete.infrastructure.payment.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fiap.lanchonete.domain.payment.entities.Payment;
import com.fiap.lanchonete.domain.payment.entities.PaymentPersistence;

import jakarta.validation.Valid;

@RequestMapping("/payment")
public interface PaymentApi {

    @PostMapping("")
    Payment savePayment(@Valid @RequestBody PaymentPersistence persistence);

}
