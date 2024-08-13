package com.fiap.lanchonete.domain.customers.ports.in;

import com.fiap.lanchonete.domain.customers.dto.CustomerPersistence;
import com.fiap.lanchonete.domain.customers.dto.CustomerResponse;

import java.util.Optional;

public interface FindCustomerInputPort {


    Optional<CustomerResponse> findCustomer(String document);

}
