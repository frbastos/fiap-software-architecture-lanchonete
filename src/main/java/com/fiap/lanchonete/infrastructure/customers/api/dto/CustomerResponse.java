package com.fiap.lanchonete.infrastructure.customers.api.dto;

public record CustomerResponse(Long id, String name, String document, String mail) {
}
