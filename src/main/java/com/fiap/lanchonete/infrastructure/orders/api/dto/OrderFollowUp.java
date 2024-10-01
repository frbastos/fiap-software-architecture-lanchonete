package com.fiap.lanchonete.infrastructure.orders.api.dto;

public record OrderFollowUp(
    Long orderNumber,
    String status,
    String dateCreation
){}
