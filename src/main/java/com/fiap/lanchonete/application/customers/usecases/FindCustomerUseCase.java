package com.fiap.lanchonete.application.customers.usecases;

import java.util.Optional;

import com.fiap.lanchonete.domain.customers.entities.Customer;

public interface FindCustomerUseCase {

    Optional<Customer> findCustomer(String document);

}
