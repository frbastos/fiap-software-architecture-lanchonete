package com.fiap.lanchonete.infrastructure.customers.persistence;


import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {

    @Query("SELECT c FROM CustomerEntity c WHERE c.document = :document")
    Optional<CustomerEntity> findCustomer(@Param("document") String document);


}