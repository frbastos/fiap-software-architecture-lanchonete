package com.fiap.lanchonete.domain.orders.entities;

import com.fiap.lanchonete.domain.customers.Customer;
import com.fiap.lanchonete.domain.products.Category;
import com.fiap.lanchonete.domain.products.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Order entity")
class OrderTest {

    Product snack = new Product(
            UUID.randomUUID(),
            "X - Bacon Egg",
            BigDecimal.valueOf(30),
            Category.SNACK
    );

    Product sideDish = new Product(
            UUID.randomUUID(),
            "French fries",
            BigDecimal.valueOf(10),
            Category.SIDE_DISH
    );

    Product drink = new Product(
            UUID.randomUUID(),
            "Coke",
            BigDecimal.valueOf(5),
            Category.DRINK
    );

    OrderItem firstOrderItem = OrderItem.create(
            snack,
            1,
            "Add more homemade mayonnaise"
    );

    OrderItem secondOrderItem = OrderItem.create(
            sideDish,
            1,
            ""
    );

    OrderItem thirdOrderItem = OrderItem.create(
            drink,
            1,
            ""
    );

    List<OrderItem> orderItems;

    Customer customer;

    @BeforeEach
    void setUp() {
        orderItems = new ArrayList<>();
        orderItems.add(firstOrderItem);
        orderItems.add(secondOrderItem);
        orderItems.add(thirdOrderItem);

        customer = new Customer(
                UUID.randomUUID(),
                "John Doe",
                "999.999.999-99",
                "john.doe@mail.com"
        );
    }

    @Test
    @DisplayName("Should be able to create an order")
    void shouldBeAbleToCreateAnOrder() {
        Order order = Order.create(
                Optional.of(customer),
                orderItems
        );

        assertNotNull(order.getId());
        assertEquals(Optional.of(customer), order.getCustomer());
        assertEquals(orderItems, order.getOrderItems());
        assertEquals(OrderState.RECEIVED, order.getState());
        assertEquals(BigDecimal.valueOf(45), order.getTotalPrice());
    }

    @Test
    @DisplayName("Should be able to restore an order")
    void shouldBeAbleToRestoreAnOrder() {
        UUID id = UUID.randomUUID();
        OrderState state = OrderState.RECEIVED;
        BigDecimal totalPrice = BigDecimal.valueOf(45);

        Order order = Order.restore(
                id,
                Optional.of(customer),
                orderItems,
                state,
                totalPrice
        );

        assertEquals(id, order.getId());
        assertEquals(Optional.of(customer), order.getCustomer());
        assertEquals(orderItems, order.getOrderItems());
        assertEquals(OrderState.RECEIVED, order.getState());
        assertEquals(BigDecimal.valueOf(45), order.getTotalPrice());
    }

    @Test
    @DisplayName("Should be able update the order state")
    void shouldBeAbleToUpdateTheOrderState() {
        Order order = Order.create(
                Optional.of(customer),
                orderItems
        );

        assertEquals(OrderState.RECEIVED, order.getState());

        order.changeState(OrderState.IN_PREPARATION);

        assertEquals(OrderState.IN_PREPARATION, order.getState());
    }
}