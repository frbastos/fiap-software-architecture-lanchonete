package com.fiap.lanchonete.domain.customers.ports.in;

import com.fiap.lanchonete.domain.customers.models.CustomerPersistence;
import com.fiap.lanchonete.domain.customers.models.CustomerResponse;
import org.springframework.context.annotation.Bean;

public interface RegisterCustomerInputPort {

    CustomerResponse save(CustomerPersistence customerPersistence);


}
