package com.fiap.lanchonete.infrastructure.customers.api.dto;

import com.fiap.lanchonete.domain.customers.entities.Customer;

public class CustomerDTOMapper {

    public CustomerResponse toResponse(Customer customer) {
        return new CustomerResponse(customer.getId(), customer.getName(), customer.getDocument(), customer.getMail());
    }

    public Customer toCustomer(CustomerRequest request) {
        return new Customer(null, request.name(), request.document(), request.mail());
    }

}
