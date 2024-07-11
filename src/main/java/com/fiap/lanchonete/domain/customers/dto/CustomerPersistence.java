package com.fiap.lanchonete.domain.customers.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record CustomerPersistence (
        @NotBlank String name,
        @NotBlank @Email String mail,

        @NotBlank @CPF(message ="Document Invalid") String document){ }
