package com.fiap.lanchonete.domain.customers.ports;

import com.fiap.lanchonete.domain.customers.dto.CustomerPersistence;
import com.fiap.lanchonete.domain.customers.dto.CustomerResponse;

import java.util.Optional;

public interface CustomerServicePort {

    CustomerResponse save(CustomerPersistence customerPersistence);

    Optional<CustomerResponse> findName(String name);

    CustomerResponse findDocument(String document);

    CustomerResponse findMail(String main);
}
