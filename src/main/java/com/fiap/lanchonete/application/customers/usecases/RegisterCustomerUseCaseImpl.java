package com.fiap.lanchonete.application.customers.usecases;

import com.fiap.lanchonete.application.customers.gateways.CustomerGateway;
import com.fiap.lanchonete.domain.customers.entities.Customer;

public class RegisterCustomerUseCaseImpl implements RegisterCustomerUseCase {

    private final CustomerGateway customerGateway;

    public RegisterCustomerUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public Customer save(Customer customer) {
        return customerGateway.save(customer);
    }

}
