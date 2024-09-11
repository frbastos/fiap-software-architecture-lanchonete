package com.fiap.lanchonete.application.customers.usecases;

import com.fiap.lanchonete.infrastructure.customers.api.dto.CustomerRequest;
import com.fiap.lanchonete.infrastructure.customers.api.dto.CustomerResponse;

public interface RegisterCustomerUseCase {

    CustomerResponse save(CustomerRequest customerPersistence);


}
