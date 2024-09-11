package com.fiap.lanchonete.infrastructure.customers.api;

import org.springframework.web.bind.annotation.RestController;

import com.fiap.lanchonete.application.customers.usecases.FindCustomerUseCase;
import com.fiap.lanchonete.application.customers.usecases.RegisterCustomerUseCase;
import com.fiap.lanchonete.infrastructure.customers.api.dto.CustomerRequest;
import com.fiap.lanchonete.infrastructure.customers.api.dto.CustomerResponse;

@RestController
public class CustomerController implements CustomerApi {

    private final FindCustomerUseCase customerService;
    private final RegisterCustomerUseCase registerCustomerInputPort;

    public CustomerController(
            FindCustomerUseCase customerService,
            RegisterCustomerUseCase registerCustomerInputPort) {

        this.customerService = customerService;
        this.registerCustomerInputPort = registerCustomerInputPort;
    }

    @Override
    public CustomerResponse saveCustomer(CustomerRequest customerPersistence) {
        return this.registerCustomerInputPort.save(customerPersistence);
    }

    @Override
    public CustomerResponse searchCustomer(String document) {
        return this.customerService.findCustomer(document).get();

    }

}
