package com.fiap.lanchonete.infrastructure.payment.gateways;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fiap.lanchonete.application.payment.gateways.PaymentProcessorGateway;
import com.fiap.lanchonete.application.payment.usecases.dto.SendPaymentNotification;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MockProcessorGateway implements PaymentProcessorGateway {

    private final String webhookUrl;
    private final RestTemplate restTemplate;

    public MockProcessorGateway(String webhookUrl, RestTemplate restTemplate) {
        this.webhookUrl = webhookUrl;
        this.restTemplate = restTemplate;
    }

    @Override
    public void sendNotification(SendPaymentNotification sendPaymentNotification) {
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(webhookUrl, sendPaymentNotification,
                    String.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                System.out.println("Simulated payment sent successfully.");
            } else {
                System.out.println("Failed to send simulated payment.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error processing simulated payment.");
        }
    }

}
