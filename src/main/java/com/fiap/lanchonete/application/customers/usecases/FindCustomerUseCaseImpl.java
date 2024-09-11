package com.fiap.lanchonete.application.customers.usecases;

import java.util.Optional;

import com.fiap.lanchonete.application.customers.gateways.CustomerGateway;
import com.fiap.lanchonete.infrastructure.customers.api.dto.CustomerResponse;
import com.fiap.lanchonete.shared.exception.NotFoundException;

public class FindCustomerUseCaseImpl implements FindCustomerUseCase {

    private final CustomerGateway customerGateway;

    public FindCustomerUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public Optional<CustomerResponse> findCustomer(String document) {
        return Optional.of(customerGateway.findCustomer( document).orElseThrow(NotFoundException::new).customerToResponse());
    }

}
