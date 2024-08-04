package com.fiap.lanchonete.infrastructure.adapters.orders.mappers;

import com.fiap.lanchonete.domain.customers.Customer;
import com.fiap.lanchonete.domain.orders.entities.Order;
import com.fiap.lanchonete.domain.orders.entities.OrderItem;
import com.fiap.lanchonete.domain.products.Category;
import com.fiap.lanchonete.domain.products.Product;
import com.fiap.lanchonete.infrastructure.adapters.customers.entity.CustomerEntity;
import com.fiap.lanchonete.infrastructure.adapters.orders.entity.OrderEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Order mapper")
class OrderMapperTest {

    @Test
    @DisplayName("Should map to persistence")
    void toPersistence() {
        Product product = new Product(
                UUID.randomUUID(),
                "X - Bacon Egg",
                BigDecimal.valueOf(30),
                Category.SNACK
        );

        Customer customer = new Customer(
                UUID.randomUUID(),
                "John Doe",
                "999.999.999-99",
                "john.doe@mail.com"
        );

        List<OrderItem> orderItems = List.of(
                OrderItem.create(
                        product,
                        1,
                        "Add more homemade mayonnaise"
                )
        );


        Order order = Order.create(
                Optional.of(customer),
                orderItems
        );

        OrderEntity orderEntity = OrderMapper.toPersistence(order);

        assertEquals(order.getId(), orderEntity.getId());
        assertEquals(order.getCustomer().map(CustomerEntity::new).orElse(null), orderEntity.getCustomer());
        assertEquals(order.getState(), orderEntity.getState());
        assertEquals(order.getTotalPrice(), orderEntity.getTotalPrice());

        assertEquals(order.getOrderItems().size(), orderEntity.getOrderItems().size());
        assertEquals(order.getOrderItems().get(0).getProduct().getId(), orderEntity.getOrderItems().get(0).getProduct().getId());
        assertEquals(order.getOrderItems().get(0).getQuantity(), orderEntity.getOrderItems().get(0).getQuantity());
        assertEquals(order.getOrderItems().get(0).getObservation(), orderEntity.getOrderItems().get(0).getObservation());

    }
}