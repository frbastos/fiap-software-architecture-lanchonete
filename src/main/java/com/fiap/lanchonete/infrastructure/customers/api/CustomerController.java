package com.fiap.lanchonete.infrastructure.customers.api;

import org.springframework.web.bind.annotation.RestController;

import com.fiap.lanchonete.application.customers.usecases.FindCustomerUseCase;
import com.fiap.lanchonete.application.customers.usecases.RegisterCustomerUseCase;
import com.fiap.lanchonete.domain.customers.entities.Customer;
import com.fiap.lanchonete.infrastructure.customers.api.dto.CustomerDTOMapper;
import com.fiap.lanchonete.infrastructure.customers.api.dto.CustomerRequest;
import com.fiap.lanchonete.infrastructure.customers.api.dto.CustomerResponse;
import com.fiap.lanchonete.shared.exception.NotFoundException;

@RestController
public class CustomerController implements CustomerApi {

    private final FindCustomerUseCase customerService;
    private final RegisterCustomerUseCase registerCustomerUseCase;
    private final CustomerDTOMapper customerDTOMapper;

    public CustomerController(
            FindCustomerUseCase customerService,
            RegisterCustomerUseCase registerCustomerUseCase,
            CustomerDTOMapper customerDTOMapper) {

        this.customerService = customerService;
        this.registerCustomerUseCase = registerCustomerUseCase;
        this.customerDTOMapper = customerDTOMapper;
    }

    @Override
    public CustomerResponse saveCustomer(CustomerRequest request) {
        Customer customerObjDomain = customerDTOMapper.toCustomer(request);
        Customer customer = this.registerCustomerUseCase.save(customerObjDomain);
        return customerDTOMapper.toResponse(customer);
    }

    @Override
    public CustomerResponse searchCustomer(String document) {
        Customer customer = this.customerService.findCustomer(document).orElseThrow(NotFoundException::new);
        return customerDTOMapper.toResponse(customer);
    }

}
