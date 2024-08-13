package com.fiap.lanchonete.domain.customers.models;

import java.util.UUID;

public record CustomerResponse(UUID id, String name, String document, String mail) {
}
