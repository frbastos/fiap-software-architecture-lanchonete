package com.fiap.lanchonete.domain.customers.entities;

public class Customer {

    private Long id;

    private String name;

    private String document;

    private String mail;

    public Customer(Long id, String name, String document, String mail) {
        this.id = id;
        this.mail = mail;
        this.document = document;
        this.name = name;
    }

    public Long getId() {return id;}

    public String getName() { return name;}

    public String getDocument() { return document; }

    public String getMail() {return mail;}


}
