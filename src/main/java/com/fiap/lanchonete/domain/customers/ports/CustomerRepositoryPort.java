package com.fiap.lanchonete.domain.customers.ports;

import java.util.Optional;

import com.fiap.lanchonete.domain.customers.Customer;

public interface CustomerRepositoryPort {

    Customer save (Customer customer);

    Optional<Customer> findCustomer(String name, String document, String mail);
}
