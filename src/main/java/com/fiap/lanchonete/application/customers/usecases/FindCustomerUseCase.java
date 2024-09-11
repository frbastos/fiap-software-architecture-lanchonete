package com.fiap.lanchonete.application.customers.usecases;

import java.util.Optional;

import com.fiap.lanchonete.infrastructure.customers.api.dto.CustomerResponse;

public interface FindCustomerUseCase {

    Optional<CustomerResponse> findCustomer(String document);

}
