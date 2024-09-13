package com.fiap.lanchonete.application.orders.exceptions;

import lombok.Getter;

@Getter
public class PaymentRefusedException extends RuntimeException {

    private String message;

    public PaymentRefusedException() {
        this.message = "Payment refused";
    }

}
