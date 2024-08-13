package com.fiap.lanchonete.application.customers.adapters.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.lanchonete.domain.customers.models.CustomerPersistence;
import com.fiap.lanchonete.domain.customers.models.CustomerResponse;
import com.fiap.lanchonete.domain.customers.ports.in.FindCustomerInputPort;
import com.fiap.lanchonete.domain.customers.ports.in.RegisterCustomerInputPort;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerApi {

    private final FindCustomerInputPort customerService;
    private final RegisterCustomerInputPort registerCustomerInputPort;

    public CustomerApi(FindCustomerInputPort customerService, RegisterCustomerInputPort registerCustomerInputPort) {
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
