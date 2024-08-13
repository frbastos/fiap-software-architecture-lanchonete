package com.fiap.lanchonete.domain.products.ports.out;

import java.util.List;

import com.fiap.lanchonete.domain.products.models.Product;

public interface GetAllProductsOutputPort {

    List<Product> listAll();

}
