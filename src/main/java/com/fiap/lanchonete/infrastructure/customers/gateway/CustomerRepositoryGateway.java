package com.fiap.lanchonete.infrastructure.customers.gateway;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.fiap.lanchonete.application.customers.gateways.CustomerGateway;
import com.fiap.lanchonete.domain.customers.entities.Customer;
import com.fiap.lanchonete.infrastructure.customers.persistence.CustomerEntity;
import com.fiap.lanchonete.infrastructure.customers.persistence.CustomerRepository;

@Component
public class CustomerRepositoryGateway implements CustomerGateway {

    private final CustomerRepository customerRepository;

    CustomerRepositoryGateway(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity(customer);
        customerEntity = this.customerRepository.save(customerEntity);
        return customerEntity.toCustomer();
    }

    @Override
    public Optional<Customer> findCustomer(String document) {
        return this.customerRepository.findCustomer(document).map(CustomerEntity::toCustomer);
    }

}
