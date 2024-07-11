package com.fiap.lanchonete.infrastructure.adapters.customers.repository;

import com.fiap.lanchonete.infrastructure.adapters.customers.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {


}
