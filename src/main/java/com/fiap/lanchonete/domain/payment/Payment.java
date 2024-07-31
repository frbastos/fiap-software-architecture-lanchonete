package com.fiap.lanchonete.domain.payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {

    private UUID id;
    private BigDecimal price;
    private LocalDateTime time;

    public Payment(BigDecimal price) {
        this.id = id;
        this.price = price;
    }

    public Payment(){}

    public Payment(UUID id, BigDecimal price, LocalDateTime time) {
        this.id = id;
        this.price = price;
        this.time = time;
    }

    public UUID getId() {return id;}

    public BigDecimal getPrice() {return price;}

    public LocalDateTime getTime() {return time;}

}
