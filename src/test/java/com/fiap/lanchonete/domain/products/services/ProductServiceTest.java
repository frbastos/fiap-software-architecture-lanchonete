package com.fiap.lanchonete.domain.products.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fiap.lanchonete.application.products.gateways.GetAllProductsGateway;
import com.fiap.lanchonete.application.products.gateways.GetProductByIdGateway;
import com.fiap.lanchonete.application.products.gateways.GetProductsByCategoryGateway;
import com.fiap.lanchonete.application.products.gateways.RemoveProductOutputPort;
import com.fiap.lanchonete.application.products.gateways.SaveProductOutputPort;
import com.fiap.lanchonete.application.products.usecases.CreateProductUseCase;
import com.fiap.lanchonete.application.products.usecases.GetAllProductsUseCaseImpl;
import com.fiap.lanchonete.application.products.usecases.GetProductByIdUseCaseImpl;
import com.fiap.lanchonete.application.products.usecases.GetProductsByCategoryUseCaseImpl;
import com.fiap.lanchonete.application.products.usecases.RemoveProductUseCaseImpl;
import com.fiap.lanchonete.application.products.usecases.UpdateProductUseCaseImpl;
import com.fiap.lanchonete.domain.products.entities.Product;
import com.fiap.lanchonete.domain.products.valueobjects.Category;
import com.fiap.lanchonete.infrastructure.products.api.dto.CreateProductRequest;
import com.fiap.lanchonete.infrastructure.products.api.dto.UpdateProductRequest;
import com.fiap.lanchonete.shared.exception.NotFoundException;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    private CreateProductUseCase createProductUseCase;

    @Mock
    private SaveProductOutputPort saveProductOutputPort;

    @InjectMocks
    private GetAllProductsUseCaseImpl getAllProductsUseCase;

    @Mock
    private GetAllProductsGateway getAllProductsOutputPort;

    @InjectMocks
    private GetProductByIdUseCaseImpl getProductByIdUseCase;

    @Mock
    private GetProductByIdGateway getProductByIdOutputPort;

    @InjectMocks
    private GetProductsByCategoryUseCaseImpl getProductsByCategoryUseCase;

    @Mock
    private GetProductsByCategoryGateway getProductsByCategoryOutputPort;

    @InjectMocks
    private RemoveProductUseCaseImpl removeProductUseCase;

    @Mock
    private RemoveProductOutputPort removeProductOutputPort;

    @InjectMocks
    private UpdateProductUseCaseImpl updateProductUseCase;

    @Captor
    private ArgumentCaptor<Product> productCaptor;

    @Mock
    private Product product;

    @Test
    void shouldCallMethodSave(){
        
        // ARRANGE
        CreateProductRequest productPersistence = new CreateProductRequest("X-Salda", new BigDecimal(25.50), Category.SNACK);

        // ACT
        this.createProductUseCase.createProduct(productPersistence);

        // ASSERT
        then(saveProductOutputPort).should().save(productCaptor.capture());

        Product product = productCaptor.getValue();

        assertEquals(product.getDescription(), product.getDescription());
        assertEquals(product.getPrice(), product.getPrice());
        assertEquals(product.getCategory(), product.getCategory());
    }

    @Test
    void shouldCallMethodUpdateFromProduct(){
        
        // ARRANGE
        UpdateProductRequest productUpdate = new UpdateProductRequest("X-Salda", new BigDecimal(25.50), Category.SNACK);
        UUID productId = UUID.randomUUID();
        given(getProductByIdOutputPort.getById(productId)).willReturn(Optional.of(product));

        // ACT
        this.updateProductUseCase.update(productId, productUpdate);

        // ASSERT
        then(product).should().update(productUpdate);

        assertEquals(product.getDescription(), product.getDescription());
        assertEquals(product.getPrice(), product.getPrice());
        assertEquals(product.getCategory(), product.getCategory());
    }

    @Test
    void shouldCallMethodUpdate(){
        
        // ARRANGE
        UpdateProductRequest productUpdate = new UpdateProductRequest("X-Salda", new BigDecimal(25.50), Category.SNACK);
        UUID productId = UUID.randomUUID();
        given(getProductByIdOutputPort.getById(productId)).willReturn(Optional.of(product));

        // ACT
        this.updateProductUseCase.update(productId, productUpdate);

        // ASSERT
        then(saveProductOutputPort).should().save(productCaptor.capture());

        Product product = productCaptor.getValue();

        assertEquals(product.getDescription(), product.getDescription());
        assertEquals(product.getPrice(), product.getPrice());
        assertEquals(product.getCategory(), product.getCategory());
    }

    @Test
    void shouldThrowNotFoundWhenCallMethodUpdate(){
        
        // ARRANGE
        UpdateProductRequest productUpdate = new UpdateProductRequest("X-Salda", new BigDecimal(25.50), Category.SNACK);
        UUID productId = UUID.randomUUID();
        given(getProductByIdOutputPort.getById(productId)).willReturn(Optional.empty());

        // ASSERT
        assertThrows(NotFoundException.class, 
            () -> this.updateProductUseCase.update(productId, productUpdate));
    }

    @Test
    void shouldCallMethodRemove(){
        
        // ARRANGE
        UUID productId = UUID.randomUUID();
        given(product.getId()).willReturn(productId);
        given(getProductByIdOutputPort.getById(productId)).willReturn(Optional.of(product));

        // ACT
        this.removeProductUseCase.remove(productId);

        // ASSERT
        then(removeProductOutputPort).should().remove(productId);
    }

    @Test
    void shouldThrowNotFoundWhenCallMethodRemove(){
        
        // ARRANGE
        UUID productId = UUID.randomUUID();
        given(getProductByIdOutputPort.getById(productId)).willReturn(Optional.empty());

        // ASSERT
        assertThrows(NotFoundException.class, 
            () -> this.removeProductUseCase.remove(productId));
    }

    @Test
    void shouldThrowNotFoundWhenCallMethodGetById(){
        
        // ARRANGE
        UUID productId = UUID.randomUUID();
        given(getProductByIdOutputPort.getById(productId)).willReturn(Optional.empty());

        // ASSERT
        assertThrows(NotFoundException.class, 
            () -> this.getProductByIdUseCase.getById(productId));
    }

}
