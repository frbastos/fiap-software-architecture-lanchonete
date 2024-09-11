package com.fiap.lanchonete.infrastructure.customers.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.lanchonete.application.customers.usecases.FindCustomerUseCase;
import com.fiap.lanchonete.application.customers.usecases.RegisterCustomerUseCase;
import com.fiap.lanchonete.domain.customers.entities.Customer;
import com.fiap.lanchonete.infrastructure.customers.api.dto.CustomerDTOMapper;
import com.fiap.lanchonete.infrastructure.customers.api.dto.CustomerRequest;
import com.fiap.lanchonete.infrastructure.customers.api.dto.CustomerResponse;
import com.fiap.lanchonete.shared.exception.NotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

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

    @PostMapping("")
    public CustomerResponse saveCustomer(@Valid @RequestBody CustomerRequest request) {
        Customer customerObjDomain = customerDTOMapper.toCustomer(request);
        Customer customer = this.registerCustomerUseCase.save(customerObjDomain);
        return customerDTOMapper.toResponse(customer);
    }

    @GetMapping("/search")
    public CustomerResponse searchCustomer(@RequestParam(value = "document", required = false) String document) {
        Customer customer = this.customerService.findCustomer(document).orElseThrow(NotFoundException::new);
        return customerDTOMapper.toResponse(customer);
    }

}
