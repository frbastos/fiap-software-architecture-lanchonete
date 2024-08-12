package com.fiap.lanchonete.domain.customers.ports.out;

import com.fiap.lanchonete.domain.customers.Customer;

public interface RegisterCustomerOutputPort {

    Customer save (Customer customer);
}
