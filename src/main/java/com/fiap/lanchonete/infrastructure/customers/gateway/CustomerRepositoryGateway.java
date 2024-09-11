package com.fiap.lanchonete.infrastructure.customers.gateway;

import java.util.Optional;

import com.fiap.lanchonete.application.customers.gateways.CustomerGateway;
import com.fiap.lanchonete.domain.customers.entities.Customer;
import com.fiap.lanchonete.infrastructure.customers.gateway.mappers.CustomerEntityMapper;
import com.fiap.lanchonete.infrastructure.customers.persistence.CustomerEntity;
import com.fiap.lanchonete.infrastructure.customers.persistence.CustomerRepository;

public class CustomerRepositoryGateway implements CustomerGateway {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public CustomerRepositoryGateway(
        CustomerRepository customerRepository,
        CustomerEntityMapper customerEntityMapper) {

        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public Customer save(Customer customer) {
        CustomerEntity entity = customerEntityMapper.toCustomerEntity(customer);
        entity = this.customerRepository.save(entity);
        return customerEntityMapper.toCustomer(entity);
    }

    @Override
    public Optional<Customer> findCustomer(String document) {
        return this.customerRepository.findCustomer(document).map(c -> customerEntityMapper.toCustomer(c));
    }

}
