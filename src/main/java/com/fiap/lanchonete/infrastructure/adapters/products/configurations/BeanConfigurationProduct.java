package com.fiap.lanchonete.infrastructure.adapters.products.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiap.lanchonete.domain.products.ports.ProductRepositoryPort;
import com.fiap.lanchonete.domain.products.ports.ProductServicePort;
import com.fiap.lanchonete.domain.products.services.ProductService;

@Configuration
public class BeanConfigurationProduct {

    @Bean
    ProductServicePort productService(ProductRepositoryPort productRepository){
        return new ProductService(productRepository);
    }

}
