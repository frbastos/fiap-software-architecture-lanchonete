package com.fiap.lanchonete.infrastructure.customers.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fiap.lanchonete.infrastructure.customers.api.dto.CustomerRequest;
import com.fiap.lanchonete.infrastructure.customers.api.dto.CustomerResponse;

import jakarta.validation.Valid;

@RequestMapping("/customers")
public interface CustomerApi {

    @PostMapping("")
    CustomerResponse saveCustomer(@Valid @RequestBody CustomerRequest customerPersistence);

    @GetMapping("/search")
    CustomerResponse searchCustomer(@RequestParam(value = "document", required = false) String document);

}
