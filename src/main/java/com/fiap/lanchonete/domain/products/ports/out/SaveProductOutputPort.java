package com.fiap.lanchonete.domain.products.ports.out;

import com.fiap.lanchonete.domain.products.models.Product;

public interface SaveProductOutputPort {

    Product save(Product product);

}
