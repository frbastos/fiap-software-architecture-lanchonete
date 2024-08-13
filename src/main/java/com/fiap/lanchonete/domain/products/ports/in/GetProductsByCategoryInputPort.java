package com.fiap.lanchonete.domain.products.ports.in;

import java.util.List;

import com.fiap.lanchonete.domain.products.models.Category;
import com.fiap.lanchonete.domain.products.models.Product;

public interface GetProductsByCategoryInputPort {

    public List<Product> getByCategory(Category category);

}
