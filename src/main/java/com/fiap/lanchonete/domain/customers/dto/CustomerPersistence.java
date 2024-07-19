package com.fiap.lanchonete.domain.customers.dto;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerPersistence (
        @NotBlank String name,
        @NotBlank @Email String mail,

        @NotBlank @CPF(message ="Document Invalid") String document){ }
