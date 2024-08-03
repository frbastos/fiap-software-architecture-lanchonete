package com.fiap.lanchonete.domain.products;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiap.lanchonete.domain.products.dto.ProductPersistence;
import com.fiap.lanchonete.domain.products.dto.ProductUpdate;

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
    }

    public Product(ProductPersistence persistence) {
        this.description = persistence.description();
        this.price = persistence.price();
        this.category = persistence.category();
    }

    public void update(ProductUpdate update) {
        this.description = update.description();
        this.price = update.price();
        this.category = update.category();
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
