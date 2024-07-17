package com.fiap.lanchonete.infrastructure.adapters.customers.repository;

import com.fiap.lanchonete.domain.customers.dto.CustomerResponse;
import com.fiap.lanchonete.infrastructure.adapters.customers.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {

    @Query("SELECT c FROM CustomerEntity c WHERE  c.name = :name OR c.document = :document OR  c.mail = :mail")
    Optional<CustomerEntity> findCustomer(@Param("name") String name, @Param("document") String document, @Param("mail") String email);


}
