package com.fiap.lanchonete.infrastructure.adapters.customers.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiap.lanchonete.domain.customers.Customer;
import com.fiap.lanchonete.domain.customers.ports.CustomerRepositoryPort;
import com.fiap.lanchonete.infrastructure.adapters.customers.entity.CustomerEntity;

@Component
public class CustomerRepositoryImpl implements CustomerRepositoryPort {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity(customer);
        customerEntity = this.customerRepository.save(customerEntity);
        return customerEntity.toCustomer();
    }

    @Override
    public Optional<Customer> findCustomer( String document) {
        return this.customerRepository.findCustomer(document).map(CustomerEntity::toCustomer);
    }


}