package com.fiap.lanchonete.infrastructure.customers.persistence;

import com.fiap.lanchonete.domain.customers.entities.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

}
