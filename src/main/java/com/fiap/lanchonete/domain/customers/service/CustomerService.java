package com.fiap.lanchonete.domain.customers.service;

import com.fiap.lanchonete.domain.customers.Customer;
import com.fiap.lanchonete.domain.customers.dto.CustomerPersistence;
import com.fiap.lanchonete.domain.customers.dto.CustomerResponse;
import com.fiap.lanchonete.domain.customers.ports.CustomerRepositoryPort;
import com.fiap.lanchonete.domain.customers.ports.CustomerServicePort;
import com.fiap.lanchonete.shared.exception.NotFoundException;

import java.util.Optional;

public class CustomerService implements CustomerServicePort {

    private final CustomerRepositoryPort customerRepositoryPort;
    public CustomerService(CustomerRepositoryPort customerRepositoryPort) {
        this.customerRepositoryPort = customerRepositoryPort;
    }


    @Override
    public CustomerResponse save(CustomerPersistence customerPersistence) {
        Customer customer = new Customer(customerPersistence);
        customer = customerRepositoryPort.save(customer);
        return customer.customerToResponse();
    }

    @Override
    public Optional<CustomerResponse> findName(String name) throws NotFoundException {
        return Optional.of(this.customerRepositoryPort.findName(name).orElseThrow(NotFoundException::new).customerToResponse());


    }

    @Override
    public CustomerResponse findDocument(String document) {
        return null;
    }

    @Override
    public CustomerResponse findMail(String main) {
        return null;
    }
}
