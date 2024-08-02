package com.fiap.lanchonete.domain.orders.entities;

import com.fiap.lanchonete.domain.products.Category;
import com.fiap.lanchonete.domain.products.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("OrderItem entity")
class OrderItemTest {

    Product product;

    @BeforeEach
    void setUp() {
        product = new Product(
                UUID.randomUUID(),
                "X - Bacon Egg",
                BigDecimal.valueOf(27.9),
                Category.SNACK
        );
    }

    @Test
    @DisplayName("Should be able to create an order item")
    void shouldBeAbleToCreateAnOrderItem() {
        OrderItem item = OrderItem.create(
                product,
                1,
                "Add more homemade mayonnaise"
        );

        assertNotNull(item.getId());
        assertEquals(product, item.getProduct());
        assertEquals(1, item.getQuantity());
        assertEquals(BigDecimal.valueOf(27.9), item.getTotalPrice());
        assertEquals("Add more homemade mayonnaise", item.getObservation());
    }

    @Test
    @DisplayName("Should be able to restore an order item")
    void shouldBeAbleToRestoreAnOrderItem() {
        UUID id = UUID.randomUUID();
        BigDecimal totalPrice = BigDecimal.valueOf(27.9);

        OrderItem item = OrderItem.restore(
                id,
                product,
                1,
                totalPrice,
                "Add more homemade mayonnaise"
        );

        assertEquals(id, item.getId());
        assertEquals(product, item.getProduct());
        assertEquals(1, item.getQuantity());
        assertEquals(totalPrice, item.getTotalPrice());
        assertEquals("Add more homemade mayonnaise", item.getObservation());
    }
}