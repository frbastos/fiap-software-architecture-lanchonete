package com.fiap.lanchonete.domain.customers.ports.in;

import java.util.Optional;

import com.fiap.lanchonete.domain.customers.models.CustomerResponse;

public interface FindCustomerInputPort {


    Optional<CustomerResponse> findCustomer(String document);

}
