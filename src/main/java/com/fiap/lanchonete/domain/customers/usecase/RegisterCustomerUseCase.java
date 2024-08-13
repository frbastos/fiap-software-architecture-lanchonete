package com.fiap.lanchonete.domain.customers.usecase;

import com.fiap.lanchonete.domain.customers.models.Customer;
import com.fiap.lanchonete.domain.customers.models.CustomerPersistence;
import com.fiap.lanchonete.domain.customers.models.CustomerResponse;
import com.fiap.lanchonete.domain.customers.ports.in.RegisterCustomerInputPort;
import com.fiap.lanchonete.domain.customers.ports.out.RegisterCustomerOutputPort;

public class RegisterCustomerUseCase implements RegisterCustomerInputPort {

    private final RegisterCustomerOutputPort registerCustomerOutputPort;
    public RegisterCustomerUseCase(RegisterCustomerOutputPort registerCustomerOutputPort) {
        this.registerCustomerOutputPort = registerCustomerOutputPort;
    }



    @Override
    public CustomerResponse save(CustomerPersistence customerPersistence) {
        Customer customer = new Customer(customerPersistence);
        customer = registerCustomerOutputPort.save(customer);
        return customer.customerToResponse();
    }


}
