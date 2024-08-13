package com.fiap.lanchonete.infrastructure.adapters.products.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiap.lanchonete.domain.products.ports.out.GetAllProductsOutputPort;
import com.fiap.lanchonete.domain.products.ports.out.GetProductByIdOutputPort;
import com.fiap.lanchonete.domain.products.ports.out.GetProductsByCategoryOutputPort;
import com.fiap.lanchonete.domain.products.ports.out.RemoveProductOutputPort;
import com.fiap.lanchonete.domain.products.ports.out.SaveProductOutputPort;
import com.fiap.lanchonete.domain.products.usecase.CreateProductUseCase;
import com.fiap.lanchonete.domain.products.usecase.GetAllProductsUseCase;
import com.fiap.lanchonete.domain.products.usecase.GetProductByIdUseCase;
import com.fiap.lanchonete.domain.products.usecase.GetProductsByCategoryUseCase;
import com.fiap.lanchonete.domain.products.usecase.RemoveProductUseCase;
import com.fiap.lanchonete.domain.products.usecase.UpdateProductUseCase;

@Configuration
public class BeanConfigurationProduct {

    @Bean
    CreateProductUseCase createProductUseCase(SaveProductOutputPort productRepository) {
        return new CreateProductUseCase(productRepository);
    }

    @Bean
    GetAllProductsUseCase getAllProductsUseCase(GetAllProductsOutputPort getAllProductsOutputPort) {
        return new GetAllProductsUseCase(getAllProductsOutputPort);
    }

    @Bean
    GetProductByIdUseCase getProductByIdUseCase(GetProductByIdOutputPort getProductByIdOutputPort) {
        return new GetProductByIdUseCase(getProductByIdOutputPort);
    }

    @Bean
    GetProductsByCategoryUseCase getProductsByCategoryUseCase(GetProductsByCategoryOutputPort getProductsByCategoryOutputPort) {
        return new GetProductsByCategoryUseCase(getProductsByCategoryOutputPort);
    }

    @Bean
    RemoveProductUseCase removeProductUseCase(RemoveProductOutputPort removeProductOutputPort, 
        GetProductByIdOutputPort getProductByIdOutputPort) {
        return new RemoveProductUseCase(removeProductOutputPort, getProductByIdOutputPort);
    }

    @Bean
    UpdateProductUseCase updateProductUseCase(GetProductByIdOutputPort getProductByIdOutputPort, SaveProductOutputPort saveProductOutputPort) {
        return new UpdateProductUseCase(getProductByIdOutputPort, saveProductOutputPort);
    }

}
