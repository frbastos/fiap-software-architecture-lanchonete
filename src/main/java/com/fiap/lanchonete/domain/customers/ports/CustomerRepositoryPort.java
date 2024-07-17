package com.fiap.lanchonete.domain.customers.ports;

import com.fiap.lanchonete.domain.customers.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepositoryPort {

    Customer save (Customer customer);

    Optional<Customer> findCustomer(String name, String document, String mail);
}
