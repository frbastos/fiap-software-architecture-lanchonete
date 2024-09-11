package com.fiap.lanchonete.infrastructure.products.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiap.lanchonete.application.products.gateways.ProductGateway;
import com.fiap.lanchonete.application.products.usecases.CreateProductUseCase;
import com.fiap.lanchonete.application.products.usecases.CreateProductUseCaseImpl;
import com.fiap.lanchonete.application.products.usecases.GetAllProductsUseCaseImpl;
import com.fiap.lanchonete.application.products.usecases.GetProductByIdUseCaseImpl;
import com.fiap.lanchonete.application.products.usecases.GetProductsByCategoryUseCaseImpl;
import com.fiap.lanchonete.application.products.usecases.RemoveProductUseCaseImpl;
import com.fiap.lanchonete.application.products.usecases.UpdateProductUseCaseImpl;
import com.fiap.lanchonete.infrastructure.products.api.dto.ProductCommandMapper;
import com.fiap.lanchonete.infrastructure.products.api.dto.ProductDTOMapper;

@Configuration
public class BeanConfigurationProduct {

    @Bean
    CreateProductUseCase createProductUseCase(ProductGateway productGateway) {
        return new CreateProductUseCaseImpl(productGateway);
    }

    @Bean
    GetAllProductsUseCaseImpl getAllProductsUseCase(ProductGateway productGateway) {
        return new GetAllProductsUseCaseImpl(productGateway);
    }

    @Bean
    GetProductByIdUseCaseImpl getProductByIdUseCase(ProductGateway productGateway) {
        return new GetProductByIdUseCaseImpl(productGateway);
    }

    @Bean
    GetProductsByCategoryUseCaseImpl getProductsByCategoryUseCase(ProductGateway productGateway) {
        return new GetProductsByCategoryUseCaseImpl(productGateway);
    }

    @Bean
    RemoveProductUseCaseImpl removeProductUseCase(ProductGateway productGateway) {
        return new RemoveProductUseCaseImpl(productGateway);
    }

    @Bean
    UpdateProductUseCaseImpl updateProductUseCase(ProductGateway productGateway) {
        return new UpdateProductUseCaseImpl(productGateway);
    }

    @Bean
    ProductDTOMapper productDTOMapper(){
        return new ProductDTOMapper();
    }

    @Bean
    ProductCommandMapper productCommandMapper(){
        return new ProductCommandMapper();
    }

}
