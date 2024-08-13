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

import com.fiap.lanchonete.domain.products.models.Category;
import com.fiap.lanchonete.domain.products.models.Product;
import com.fiap.lanchonete.domain.products.models.ProductPersistence;
import com.fiap.lanchonete.domain.products.models.ProductUpdate;
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
import com.fiap.lanchonete.shared.exception.NotFoundException;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    private CreateProductUseCase createProductUseCase;

    @Mock
    private SaveProductOutputPort saveProductOutputPort;

    @InjectMocks
    private GetAllProductsUseCase getAllProductsUseCase;

    @Mock
    private GetAllProductsOutputPort getAllProductsOutputPort;

    @InjectMocks
    private GetProductByIdUseCase getProductByIdUseCase;

    @Mock
    private GetProductByIdOutputPort getProductByIdOutputPort;

    @InjectMocks
    private GetProductsByCategoryUseCase getProductsByCategoryUseCase;

    @Mock
    private GetProductsByCategoryOutputPort getProductsByCategoryOutputPort;

    @InjectMocks
    private RemoveProductUseCase removeProductUseCase;

    @Mock
    private RemoveProductOutputPort removeProductOutputPort;

    @InjectMocks
    private UpdateProductUseCase updateProductUseCase;

    @Captor
    private ArgumentCaptor<Product> productCaptor;

    @Mock
    private Product product;

    @Test
    void shouldCallMethodSave(){
        
        // ARRANGE
        ProductPersistence productPersistence = new ProductPersistence("X-Salda", new BigDecimal(25.50), Category.SNACK);

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
        ProductUpdate productUpdate = new ProductUpdate("X-Salda", new BigDecimal(25.50), Category.SNACK);
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
        ProductUpdate productUpdate = new ProductUpdate("X-Salda", new BigDecimal(25.50), Category.SNACK);
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
        ProductUpdate productUpdate = new ProductUpdate("X-Salda", new BigDecimal(25.50), Category.SNACK);
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
