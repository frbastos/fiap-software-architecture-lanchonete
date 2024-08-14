package com.fiap.lanchonete.domain.payment.models;

import com.fiap.lanchonete.domain.payment.models.PaymentPersistence;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {

    private UUID id;
    private BigDecimal price;
    private LocalDateTime time;

    private UUID idOrder;

    public Payment(BigDecimal price, UUID idOrder) {
        this.id = id;
        this.price = price;
        this.idOrder = idOrder;
    }

    public Payment(){}

    public Payment(UUID id, BigDecimal price, LocalDateTime time, UUID idOrder) {
        this.id = id;
        this.price = price;
        this.time = time;
        this.idOrder = idOrder;
    }

    public Payment(PaymentPersistence persistence) {
        this.price = persistence.price();
        this.idOrder = persistence.idOrder();
    }

    public UUID getId() {return id;}

    public BigDecimal getPrice() {return price;}

    public LocalDateTime getTime() {return time;}

    public UUID getIdOrder(){return idOrder;}
}