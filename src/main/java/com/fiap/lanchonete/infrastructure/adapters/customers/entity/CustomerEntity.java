package com.fiap.lanchonete.infrastructure.adapters.customers.entity;

import com.fiap.lanchonete.domain.customers.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank

    private String name;

    @NotBlank
    private String document;

    @NotBlank
    private String mail;


    public CustomerEntity(Customer customer){
        this.id = customer.getId();
        this.name = customer.getName();
        this.document = customer.getDocument();
        this.mail = customer.getMail();
    }

    public Customer toCustomer(){return new Customer(this.id, this.name, this.document, this.mail);}

}
