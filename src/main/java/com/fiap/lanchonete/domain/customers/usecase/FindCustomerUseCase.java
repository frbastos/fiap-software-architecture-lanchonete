package com.fiap.lanchonete.domain.customers.usecase;

import java.util.Optional;

import com.fiap.lanchonete.domain.customers.models.CustomerResponse;
import com.fiap.lanchonete.domain.customers.ports.in.FindCustomerInputPort;
import com.fiap.lanchonete.domain.customers.ports.out.FindCustomerOutputPort;
import com.fiap.lanchonete.shared.exception.NotFoundException;

public class FindCustomerUseCase implements FindCustomerInputPort {

    private final FindCustomerOutputPort customerRepositoryPort;
    public FindCustomerUseCase(FindCustomerOutputPort customerRepositoryPort) {
        this.customerRepositoryPort = customerRepositoryPort;
    }

    @Override
    public Optional<CustomerResponse> findCustomer(String document) {
        return Optional.of(customerRepositoryPort.findCustomer( document).orElseThrow(NotFoundException::new).customerToResponse());
    }





}
