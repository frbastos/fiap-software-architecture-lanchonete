package com.fiap.lanchonete.infrastructure.adapters.customers.mapper;

import org.springframework.stereotype.Component;

import com.fiap.lanchonete.domain.customers.models.Customer;
import com.fiap.lanchonete.infrastructure.adapters.customers.entity.CustomerEntity;

@Component
public class CustomerMapper {

    public Customer toCustomer(CustomerEntity entity) {
        return new Customer(
            entity.getId(), 
            entity.getName(), 
            entity.getDocument(), 
            entity.getMail());
    }

    public CustomerEntity toCustomerEntity(Customer customer) {
        return new CustomerEntity(
            customer.getId(), 
            customer.getName(), 
            customer.getDocument(), 
            customer.getMail());
    }

}
