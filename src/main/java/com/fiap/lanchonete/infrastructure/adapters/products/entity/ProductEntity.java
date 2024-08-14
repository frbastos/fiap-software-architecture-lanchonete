package com.fiap.lanchonete.infrastructure.adapters.products.entity;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiap.lanchonete.domain.products.models.Category;
import com.fiap.lanchonete.domain.products.models.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    private String description;

    @DecimalMin(value = "0.0")
    private BigDecimal price;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Category category;

    public ProductEntity(Product product){
        this.id = product.getId();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.category = product.getCategory();
    }
}
