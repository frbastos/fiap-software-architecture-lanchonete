package com.fiap.lanchonete.application.customers.adapters.resource;

import com.fiap.lanchonete.domain.customers.dto.CustomerPersistence;
import com.fiap.lanchonete.domain.customers.dto.CustomerResponse;
import com.fiap.lanchonete.domain.customers.ports.CustomerServicePort;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerResource {

    private final CustomerServicePort customerService;

    public CustomerResource(CustomerServicePort customerService) {
        this.customerService = customerService;
    }

    @PostMapping("")
    public CustomerResponse saveCustomer(@Valid @RequestBody CustomerPersistence customerPersistence) {
        return this.customerService.save(customerPersistence);
    }

    @GetMapping("/search")
    public CustomerResponse searchCustomer(@RequestParam(value = "document", required = false) String document
                                          ) {

        return this.customerService.findCustomer(document).get();

    }

}
