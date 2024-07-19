package com.fiap.lanchonete.domain.customers.dto;

import java.util.UUID;

public record CustomerResponse(UUID id, String name, String document, String mail) {
}
