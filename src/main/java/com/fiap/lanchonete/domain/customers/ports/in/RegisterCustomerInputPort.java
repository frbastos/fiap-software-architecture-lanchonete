package com.fiap.lanchonete.domain.customers.ports.in;

import com.fiap.lanchonete.domain.customers.models.CustomerPersistence;
import com.fiap.lanchonete.domain.customers.models.CustomerResponse;

public interface RegisterCustomerInputPort {

    CustomerResponse save(CustomerPersistence customerPersistence);


}
