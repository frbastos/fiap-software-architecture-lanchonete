package com.fiap.lanchonete.infrastructure.payment.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.lanchonete.application.payment.usecases.ProcessPaymentMockUseCase;
import com.fiap.lanchonete.application.payment.usecases.command.ProcessPaymentMockCommand;
import com.fiap.lanchonete.infrastructure.payment.api.dto.PaymentCommandMapper;
import com.fiap.lanchonete.infrastructure.payment.api.dto.PaymentRequest;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final ProcessPaymentMockUseCase processPaymentMockUseCase;
    private final PaymentCommandMapper paymentCommandMapper;

    public PaymentController(
            ProcessPaymentMockUseCase processPaymentMockUseCase,
            PaymentCommandMapper paymentCommandMapper) {

        this.processPaymentMockUseCase = processPaymentMockUseCase;
        this.paymentCommandMapper = paymentCommandMapper;
    }

    @PostMapping("/process-payment-mock")
    public ResponseEntity<?> processPaymentMock(@RequestBody PaymentRequest paymentRequest) {
        ProcessPaymentMockCommand processPaymentMockCommand = paymentCommandMapper.toProcessPaymentMockCommand(paymentRequest);
        processPaymentMockUseCase.process(processPaymentMockCommand);
        return ResponseEntity.ok().build();
    }

}
