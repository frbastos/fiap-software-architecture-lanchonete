package com.fiap.lanchonete.domain.products.ports.out;

import java.util.List;

import com.fiap.lanchonete.domain.products.models.Category;
import com.fiap.lanchonete.domain.products.models.Product;

public interface GetProductsByCategoryOutputPort {

    public List<Product> getByCategory(Category category);

}
