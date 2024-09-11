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

import com.fiap.lanchonete.application.products.gateways.ProductGateway;
import com.fiap.lanchonete.application.products.usecases.CreateProductUseCaseImpl;
import com.fiap.lanchonete.application.products.usecases.GetAllProductsUseCaseImpl;
import com.fiap.lanchonete.application.products.usecases.GetProductByIdUseCaseImpl;
import com.fiap.lanchonete.application.products.usecases.GetProductsByCategoryUseCaseImpl;
import com.fiap.lanchonete.application.products.usecases.RemoveProductUseCaseImpl;
import com.fiap.lanchonete.application.products.usecases.UpdateProductUseCaseImpl;
import com.fiap.lanchonete.application.products.usecases.commands.UpdateProductCommand;
import com.fiap.lanchonete.domain.products.entities.Product;
import com.fiap.lanchonete.domain.products.valueobjects.Category;
import com.fiap.lanchonete.shared.exception.NotFoundException;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductGateway productGateway;

    @InjectMocks
    private CreateProductUseCaseImpl createProductUseCase;

    @InjectMocks
    private GetAllProductsUseCaseImpl getAllProductsUseCase;

    @InjectMocks
    private GetProductByIdUseCaseImpl getProductByIdUseCase;

    @InjectMocks
    private GetProductsByCategoryUseCaseImpl getProductsByCategoryUseCase;

    @InjectMocks
    private RemoveProductUseCaseImpl removeProductUseCase;

    @InjectMocks
    private UpdateProductUseCaseImpl updateProductUseCase;

    @Captor
    private ArgumentCaptor<Product> productCaptor;

    @Mock
    private Product productMock;

    @Test
    void shouldCallMethodSave(){
        
        // ARRANGE
        Product product = new Product("X-Salda", new BigDecimal(25.50), Category.SNACK);

        // ACT
        this.createProductUseCase.createProduct(product);

        // ASSERT
        then(productGateway).should().save(productCaptor.capture());

        Product productMock = productCaptor.getValue();

        assertEquals(product.getDescription(), productMock.getDescription());
        assertEquals(product.getPrice(), productMock.getPrice());
        assertEquals(product.getCategory(), productMock.getCategory());
    }

    @Test
    void shouldCallMethodUpdateFromProduct(){
        
        // ARRANGE
        UUID productId = UUID.randomUUID();
        UpdateProductCommand updateProductCommand = new UpdateProductCommand(productId, "X-Salda", new BigDecimal(25.50), Category.SNACK);
        given(productGateway.getById(productId)).willReturn(Optional.of(productMock));

        // ACT
        this.updateProductUseCase.update(updateProductCommand);

        // ASSERT
        then(productMock).should().update(updateProductCommand);

        assertEquals(productMock.getDescription(), productMock.getDescription());
        assertEquals(productMock.getPrice(), productMock.getPrice());
        assertEquals(productMock.getCategory(), productMock.getCategory());
    }

    @Test
    void shouldCallMethodUpdate(){
        
        // ARRANGE
        UUID productId = UUID.randomUUID();
        UpdateProductCommand updateProductCommand = new UpdateProductCommand(productId, "X-Salda", new BigDecimal(25.50), Category.SNACK);
        given(productGateway.getById(productId)).willReturn(Optional.of(productMock));

        // ACT
        this.updateProductUseCase.update(updateProductCommand);

        // ASSERT
        then(productGateway).should().save(productCaptor.capture());

        Product product = productCaptor.getValue();

        assertEquals(product.getDescription(), product.getDescription());
        assertEquals(product.getPrice(), product.getPrice());
        assertEquals(product.getCategory(), product.getCategory());
    }

    @Test
    void shouldThrowNotFoundWhenCallMethodUpdate(){
        
        // ARRANGE
        UUID productId = UUID.randomUUID();
        UpdateProductCommand updateProductCommand = new UpdateProductCommand(productId, "X-Salda", new BigDecimal(25.50), Category.SNACK);
        given(productGateway.getById(productId)).willReturn(Optional.empty());

        // ASSERT
        assertThrows(NotFoundException.class, 
            () -> this.updateProductUseCase.update(updateProductCommand));
    }

    @Test
    void shouldCallMethodRemove(){
        
        // ARRANGE
        UUID productId = UUID.randomUUID();
        given(productMock.getId()).willReturn(productId);
        given(productGateway.getById(productId)).willReturn(Optional.of(productMock));

        // ACT
        this.removeProductUseCase.remove(productId);

        // ASSERT
        then(removeProductUseCase).should().remove(productId);
    }

    @Test
    void shouldThrowNotFoundWhenCallMethodRemove(){
        
        // ARRANGE
        UUID productId = UUID.randomUUID();
        given(productGateway.getById(productId)).willReturn(Optional.empty());

        // ASSERT
        assertThrows(NotFoundException.class, 
            () -> this.removeProductUseCase.remove(productId));
    }

    @Test
    void shouldThrowNotFoundWhenCallMethodGetById(){
        
        // ARRANGE
        UUID productId = UUID.randomUUID();
        given(productGateway.getById(productId)).willReturn(Optional.empty());

        // ASSERT
        assertThrows(NotFoundException.class, 
            () -> this.getProductByIdUseCase.getById(productId));
    }

}
