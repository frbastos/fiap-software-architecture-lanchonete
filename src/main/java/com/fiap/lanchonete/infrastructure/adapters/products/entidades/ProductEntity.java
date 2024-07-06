package com.fiap.lanchonete.infrastructure.adapters.products.entidades;

import com.fiap.lanchonete.domain.products.Category;
import com.fiap.lanchonete.domain.products.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

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
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.category = product.getCategory();
    }

    public Product toProduct() {
        return new Product(this.id, this.description, this.price, this.category);
    }
}
