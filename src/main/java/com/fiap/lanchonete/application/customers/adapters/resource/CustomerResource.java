package com.fiap.lanchonete.application.customers.adapters.resource;

import com.fiap.lanchonete.domain.customers.ports.in.RegisterCustomerInputPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.lanchonete.domain.customers.dto.CustomerPersistence;
import com.fiap.lanchonete.domain.customers.dto.CustomerResponse;
import com.fiap.lanchonete.domain.customers.ports.in.FindCustomerInputPort;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerResource {

    private final FindCustomerInputPort customerService;
    private final RegisterCustomerInputPort registerCustomerInputPort;

    public CustomerResource(FindCustomerInputPort customerService, RegisterCustomerInputPort registerCustomerInputPort) {
        this.customerService = customerService;
        this.registerCustomerInputPort = registerCustomerInputPort;
    }

    @PostMapping("")
    public CustomerResponse saveCustomer(@Valid @RequestBody CustomerPersistence customerPersistence) {
        return this.registerCustomerInputPort.save(customerPersistence);
    }

    @GetMapping("/search")
    public CustomerResponse searchCustomer(@RequestParam(value = "document", required = false) String document
                                          ) {

        return this.customerService.findCustomer(document).get();

    }

}
