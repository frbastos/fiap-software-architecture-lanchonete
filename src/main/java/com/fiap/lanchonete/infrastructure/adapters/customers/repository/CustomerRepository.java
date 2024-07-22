package com.fiap.lanchonete.infrastructure.adapters.customers.repository;

<<<<<<< HEAD
import com.fiap.lanchonete.infrastructure.adapters.customers.entity.CustomerEntity;
=======
import java.util.Optional;
import java.util.UUID;

>>>>>>> d52793157dc9ffeb982491212156475a06c2977c
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

<<<<<<< HEAD
import java.util.Optional;
import java.util.UUID;
=======
import com.fiap.lanchonete.infrastructure.adapters.customers.entity.CustomerEntity;
>>>>>>> d52793157dc9ffeb982491212156475a06c2977c

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {

    @Query("SELECT c FROM CustomerEntity c WHERE c.document = :document")
    Optional<CustomerEntity> findCustomer( @Param("document") String document);


}
