package com.fiap.lanchonete.application.payment.usecases;

import java.time.LocalDateTime;
import java.util.Random;

import com.fiap.lanchonete.application.payment.gateways.PaymentProcessorGateway;
import com.fiap.lanchonete.application.payment.usecases.command.ProcessPaymentMockCommand;
import com.fiap.lanchonete.application.payment.usecases.dto.SendPaymentNotification;
import com.fiap.lanchonete.domain.payment.valueobjects.PaymentStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProcessPaymentMockUseCaseImpl implements ProcessPaymentMockUseCase {

    private final PaymentProcessorGateway paymentProcessorGateway;

    public ProcessPaymentMockUseCaseImpl(
        PaymentProcessorGateway paymentProcessorGateway) {
        this.paymentProcessorGateway = paymentProcessorGateway;
    }

    @Override
    public void process(ProcessPaymentMockCommand processPaymentMockCommand) {

        SendPaymentNotification sendPaymentNotification = new SendPaymentNotification(
                processPaymentMockCommand.orderId(),
                processPaymentMockCommand.amount(),
                LocalDateTime.now(),
                generateRandomNumberTrasaction(),
                PaymentStatus.APPROVED);

        paymentProcessorGateway.sendNotification(sendPaymentNotification);
    }

    private Long generateRandomNumberTrasaction(){
        Random random = new Random();
        long randomLong = random.nextLong();
        return randomLong == Long.MIN_VALUE ? 0 : Math.abs(randomLong);
    }

}
