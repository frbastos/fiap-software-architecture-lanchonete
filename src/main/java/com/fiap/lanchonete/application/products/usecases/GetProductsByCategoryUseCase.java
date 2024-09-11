package com.fiap.lanchonete.application.products.usecases;

import java.util.List;

import com.fiap.lanchonete.domain.products.entities.Product;
import com.fiap.lanchonete.domain.products.valueobjects.Category;

public interface GetProductsByCategoryUseCase {

    List<Product> getByCategory(Category category);
}
