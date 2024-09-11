package com.fiap.lanchonete.application.customers.usecases;

import com.fiap.lanchonete.domain.customers.entities.Customer;

public interface RegisterCustomerUseCase {

    Customer save(Customer customerPersistence);

}
