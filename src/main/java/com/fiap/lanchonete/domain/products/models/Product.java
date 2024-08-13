package com.fiap.lanchonete.domain.products.models;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiap.lanchonete.shared.validations.NumberValidator;
import com.fiap.lanchonete.shared.validations.StringValidator;

public class Product {

    private UUID id;
    private String description;
    private BigDecimal price;
    private Category category;

    public Product(UUID id, String description, BigDecimal price, Category category) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.category = category;
        this.validation();
    }

    public Product(ProductPersistence persistence) {
        this(null, persistence.description(), persistence.price(), persistence.category());
    }

    private void validation() {
        if(StringValidator.isNullOrEmpty(description)){
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        if(NumberValidator.isNegative(price)){
            throw new IllegalArgumentException("Price cannot be null or negative");
        }
        if(getCategory() == null){
            throw new IllegalArgumentException("Category cannot be null");
        }
    }

    public void update(ProductUpdate update) {
        this.description = update.description();
        this.price = update.price();
        this.category = update.category();
        this.validation();
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

}
