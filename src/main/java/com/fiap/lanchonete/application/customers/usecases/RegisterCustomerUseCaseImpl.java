package com.fiap.lanchonete.application.customers.usecases;

import com.fiap.lanchonete.application.customers.gateways.CustomerGateway;
import com.fiap.lanchonete.domain.customers.entities.Customer;
import com.fiap.lanchonete.infrastructure.customers.api.dto.CustomerRequest;
import com.fiap.lanchonete.infrastructure.customers.api.dto.CustomerResponse;

public class RegisterCustomerUseCaseImpl implements RegisterCustomerUseCase {

    private final CustomerGateway customerGateway;

    public RegisterCustomerUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public CustomerResponse save(CustomerRequest customerPersistence) {
        Customer customer = new Customer(customerPersistence);
        customer = customerGateway.save(customer);
        return customer.customerToResponse();
    }

}
