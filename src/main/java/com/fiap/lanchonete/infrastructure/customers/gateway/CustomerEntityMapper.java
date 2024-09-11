package com.fiap.lanchonete.infrastructure.customers.gateway;

import org.springframework.stereotype.Component;

import com.fiap.lanchonete.domain.customers.entities.Customer;
import com.fiap.lanchonete.infrastructure.customers.persistence.CustomerEntity;

@Component
public class CustomerEntityMapper {

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
