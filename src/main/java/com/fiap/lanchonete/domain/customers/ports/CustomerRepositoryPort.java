package com.fiap.lanchonete.domain.customers.ports;

import com.fiap.lanchonete.domain.customers.Customer;

import java.util.Optional;

public interface CustomerRepositoryPort {

    Customer save (Customer customer);

    Optional<Customer>findName(String name);
}
