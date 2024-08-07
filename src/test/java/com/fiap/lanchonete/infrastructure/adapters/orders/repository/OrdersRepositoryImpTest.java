package com.fiap.lanchonete.infrastructure.adapters.orders.repository;

import com.fiap.lanchonete.domain.customers.Customer;
import com.fiap.lanchonete.domain.orders.entities.Order;
import com.fiap.lanchonete.domain.orders.entities.OrderItem;
import com.fiap.lanchonete.domain.products.Category;
import com.fiap.lanchonete.domain.products.Product;
import com.fiap.lanchonete.infrastructure.adapters.orders.entity.OrderEntity;
import com.fiap.lanchonete.infrastructure.adapters.orders.mappers.OrderMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrdersRepositoryImpTest {

    private OrdersRepository repository;
    private OrdersRepositoryImp sut;

    @BeforeEach
    public void setup() {
        repository = Mockito.mock(OrdersRepository.class);
        sut = new OrdersRepositoryImp(repository);
    }

    @Test
    @DisplayName("Should be able to save")
    public void shouldBeAbleToSave() {
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

        OrderEntity mappedOrder = OrderMapper.toPersistence(order);

        Mockito.when(repository.save(mappedOrder)).thenReturn(mappedOrder);

        sut.save(order);

        Mockito.verify(repository, Mockito.times(1)).save(mappedOrder);
    }
}