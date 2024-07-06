package com.fiap.lanchonete.infrastructure.adapters.products.configurations;

import com.fiap.lanchonete.domain.products.ports.ProductRepositoryPort;
import com.fiap.lanchonete.domain.products.ports.ProductServicePort;
import com.fiap.lanchonete.domain.products.services.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    ProductServicePort productService(ProductRepositoryPort productRepository){
        return new ProductService(productRepository);
    }

}
