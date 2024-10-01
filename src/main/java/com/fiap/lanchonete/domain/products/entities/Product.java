package com.fiap.lanchonete.domain.products.entities;

import java.math.BigDecimal;

import com.fiap.lanchonete.application.products.usecases.commands.UpdateProductCommand;
import com.fiap.lanchonete.domain.products.valueobjects.Category;
import com.fiap.lanchonete.shared.validations.NumberValidator;
import com.fiap.lanchonete.shared.validations.StringValidator;

public class Product {

    private Long id;
    private String description;
    private BigDecimal price;
    private Category category;

    public Product(Long id, String description, BigDecimal price, Category category) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.category = category;
        this.validation();
    }

    public Product(String description, BigDecimal price, Category category) {
        this(null, description, price, category);
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

    public void update(UpdateProductCommand update) {
        this.description = update.description();
        this.price = update.price();
        this.category = update.category();
        this.validation();
    }

    public Long getId() {
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
