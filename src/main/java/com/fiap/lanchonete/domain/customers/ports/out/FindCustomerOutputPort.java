package com.fiap.lanchonete.domain.customers.ports.out;

import java.util.Optional;

import com.fiap.lanchonete.domain.customers.models.Customer;

public interface FindCustomerOutputPort {

    Customer save (Customer customer);

    Optional<Customer> findCustomer( String document);
}
