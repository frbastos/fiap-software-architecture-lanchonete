package com.fiap.lanchonete.application.customers.usecases;

import java.util.Optional;

import com.fiap.lanchonete.application.customers.gateways.CustomerGateway;
import com.fiap.lanchonete.domain.customers.entities.Customer;

public class FindCustomerUseCaseImpl implements FindCustomerUseCase {

    private final CustomerGateway customerGateway;

    public FindCustomerUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public Optional<Customer> findCustomer(String document) {
        return customerGateway.findCustomer(document);
    }

}
