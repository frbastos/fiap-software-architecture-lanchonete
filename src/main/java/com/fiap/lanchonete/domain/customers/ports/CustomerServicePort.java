package com.fiap.lanchonete.domain.customers.ports;

import com.fiap.lanchonete.domain.customers.dto.CustomerPersistence;
import com.fiap.lanchonete.domain.customers.dto.CustomerResponse;

import java.util.Optional;

public interface CustomerServicePort {

    CustomerResponse save(CustomerPersistence customerPersistence);

    Optional<CustomerResponse> findCustomer(String document);

}
