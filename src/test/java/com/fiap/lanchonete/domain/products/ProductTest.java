package com.fiap.lanchonete.domain.products;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.fiap.lanchonete.domain.products.models.Category;
import com.fiap.lanchonete.domain.products.models.Product;
import com.fiap.lanchonete.domain.products.models.ProductUpdate;

public class ProductTest {

    @Test
    void shouldCreateValidProductScenario1() {
        Product product = new Product(null, "X-Salad", new BigDecimal(25.5), Category.SNACK);
        assertEquals(null, product.getId());
        assertEquals("X-Salad", product.getDescription());
        assertEquals(new BigDecimal(25.5), product.getPrice());
        assertEquals(Category.SNACK, product.getCategory());
    }

    @Test
    void shouldCreateValidProductScenario2() {
        UUID id = UUID.randomUUID();
        Product product = new Product(id, "X-Salad", new BigDecimal(25.5), Category.SNACK);
        assertEquals(id, product.getId());
        assertEquals("X-Salad", product.getDescription());
        assertEquals(new BigDecimal(25.5), product.getPrice());
        assertEquals(Category.SNACK, product.getCategory());
    }

    @Test
    void shouldThrowNullOrEmptyDescription() {
        assertThrows(IllegalArgumentException.class,
                () -> new Product(null, null, new BigDecimal(25.5), Category.SNACK));

        assertThrows(IllegalArgumentException.class,
                () -> new Product(null, "", new BigDecimal(25.5), Category.SNACK));

        assertThrows(IllegalArgumentException.class,
                () -> new Product(null, "  ", new BigDecimal(25.5), Category.SNACK));
    }

    @Test
    void shouldThrowNegativeNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> new Product(null, "X-Salad", new BigDecimal(-25.5), Category.SNACK));
    }

    @Test
    void shouldThrowNullCategory() {
        assertThrows(IllegalArgumentException.class,
                () -> new Product(null, "X-Salad", new BigDecimal(-25.5), Category.SNACK));
    }

    @Test
    void shouldUpdateProduct(){

        Product product = new Product(null, "X-Salad", new BigDecimal(25.5), Category.SNACK);
        ProductUpdate productUpdate = new ProductUpdate("X-Bacon", new BigDecimal(45.50), Category.SNACK);
        
        product.update(productUpdate);

        assertEquals(product.getDescription(), productUpdate.description());
        assertEquals(product.getPrice(), productUpdate.price());
        assertEquals(product.getCategory(), productUpdate.category());
    }

}
