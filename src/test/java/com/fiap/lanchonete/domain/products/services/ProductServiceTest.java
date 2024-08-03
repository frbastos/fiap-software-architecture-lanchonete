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

import com.fiap.lanchonete.domain.products.Category;
import com.fiap.lanchonete.domain.products.Product;
import com.fiap.lanchonete.domain.products.dto.ProductPersistence;
import com.fiap.lanchonete.domain.products.dto.ProductUpdate;
import com.fiap.lanchonete.domain.products.ports.ProductRepositoryPort;
import com.fiap.lanchonete.shared.exception.NotFoundException;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepositoryPort productRepositoryPort;

    @Captor
    private ArgumentCaptor<Product> productCaptor;

    @Mock
    private Product product;

    @Test
    void shouldCallMethodSave(){
        
        // ARRANGE
        ProductPersistence productPersistence = new ProductPersistence("X-Salda", new BigDecimal(25.50), Category.SNACK);

        // ACT
        this.productService.save(productPersistence);

        // ASSERT
        then(productRepositoryPort).should().save(productCaptor.capture());

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
        given(productRepositoryPort.getById(productId)).willReturn(Optional.of(product));

        // ACT
        this.productService.update(productId, productUpdate);

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
        given(productRepositoryPort.getById(productId)).willReturn(Optional.of(product));

        // ACT
        this.productService.update(productId, productUpdate);

        // ASSERT
        then(productRepositoryPort).should().save(productCaptor.capture());

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
        given(productRepositoryPort.getById(productId)).willReturn(Optional.empty());

        // ASSERT
        assertThrows(NotFoundException.class, 
            () -> this.productService.update(productId, productUpdate));
    }

    @Test
    void shouldCallMethodRemove(){
        
        // ARRANGE
        UUID productId = UUID.randomUUID();
        given(product.getId()).willReturn(productId);
        given(productRepositoryPort.getById(productId)).willReturn(Optional.of(product));

        // ACT
        this.productService.remove(productId);

        // ASSERT
        then(productRepositoryPort).should().remove(productId);
    }

    @Test
    void shouldThrowNotFoundWhenCallMethodRemove(){
        
        // ARRANGE
        UUID productId = UUID.randomUUID();
        given(productRepositoryPort.getById(productId)).willReturn(Optional.empty());

        // ASSERT
        assertThrows(NotFoundException.class, 
            () -> this.productService.remove(productId));
    }

    @Test
    void shouldThrowNotFoundWhenCallMethodGetById(){
        
        // ARRANGE
        UUID productId = UUID.randomUUID();
        given(productRepositoryPort.getById(productId)).willReturn(Optional.empty());

        // ASSERT
        assertThrows(NotFoundException.class, 
            () -> this.productService.getById(productId));
    }

}
