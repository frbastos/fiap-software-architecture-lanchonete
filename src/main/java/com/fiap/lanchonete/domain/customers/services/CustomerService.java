package com.fiap.lanchonete.domain.customers.services;

import java.util.Optional;

import com.fiap.lanchonete.domain.customers.Customer;
import com.fiap.lanchonete.domain.customers.dto.CustomerPersistence;
import com.fiap.lanchonete.domain.customers.dto.CustomerResponse;
import com.fiap.lanchonete.domain.customers.ports.CustomerRepositoryPort;
import com.fiap.lanchonete.domain.customers.ports.CustomerServicePort;
import com.fiap.lanchonete.shared.exception.NotFoundException;

public class CustomerService implements CustomerServicePort {

    private final CustomerRepositoryPort customerRepositoryPort;
    public CustomerService(CustomerRepositoryPort customerRepositoryPort) {
        this.customerRepositoryPort = customerRepositoryPort;
    }

    @Override
    public Optional<CustomerResponse> findCustomer(String document) {
        return Optional.of(customerRepositoryPort.findCustomer( document).orElseThrow(NotFoundException::new).customerToResponse());
    }


    @Override
    public CustomerResponse save(CustomerPersistence customerPersistence) {
        Customer customer = new Customer(customerPersistence);
        customer = customerRepositoryPort.save(customer);
        return customer.customerToResponse();
    }


}
