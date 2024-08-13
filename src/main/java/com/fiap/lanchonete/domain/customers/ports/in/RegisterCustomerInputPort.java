package com.fiap.lanchonete.domain.customers.ports.in;

import com.fiap.lanchonete.domain.customers.dto.CustomerPersistence;
import com.fiap.lanchonete.domain.customers.dto.CustomerResponse;

public interface RegisterCustomerInputPort {

    CustomerResponse save(CustomerPersistence customerPersistence);


}
