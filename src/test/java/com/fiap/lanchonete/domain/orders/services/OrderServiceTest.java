package com.fiap.lanchonete.domain.orders.services;

import com.fiap.lanchonete.domain.customers.Customer;
import com.fiap.lanchonete.domain.customers.ports.CustomerRepositoryPort;
import com.fiap.lanchonete.domain.orders.dtos.CreateOrderRequest;
import com.fiap.lanchonete.domain.orders.dtos.OrderItemRequest;
import com.fiap.lanchonete.domain.orders.entities.Order;
import com.fiap.lanchonete.domain.orders.ports.OrdersRepositoryPort;
import com.fiap.lanchonete.domain.products.Category;
import com.fiap.lanchonete.domain.products.Product;
import com.fiap.lanchonete.domain.products.ports.ProductRepositoryPort;
import com.fiap.lanchonete.shared.exception.NotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

@DisplayName("Order service")
class OrderServiceTest {

    @Mock
    private CustomerRepositoryPort customersRepository;

    @Mock
    private ProductRepositoryPort productsRepository;

    @Mock
    private OrdersRepositoryPort ordersRepository;

    private OrderService sut;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sut = new OrderService(customersRepository, productsRepository, ordersRepository);
    }

    @Test
    @DisplayName("Should throw an exception when customer not found")
    void shouldThrowAnExceptionWhenCustomerNotFound() {
        String customerId = "123";
        CreateOrderRequest request = new CreateOrderRequest(customerId, List.of());
        Optional<Customer> customer = Optional.empty();
        when(customersRepository.findCustomer(customerId)).thenReturn(customer);

        Assertions.assertThrows(NotFoundException.class, () -> sut.create(request));
    }

    @Test
    @DisplayName("Should throw an exception when product not found")
    void shouldThrowAnExceptionWhenProductNotFound() {
        CreateOrderRequest request = new CreateOrderRequest("123", List.of(new OrderItemRequest(UUID.randomUUID(), 1, "")));
        when(customersRepository.findCustomer("123")).thenReturn(Optional.of(new Customer(
                UUID.randomUUID(),
                "John Doe",
                "123",
                "john.doe@mail.com"
        )));
        when(productsRepository.getById(any())).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class, () -> sut.create(request));
    }

    @Test
    @DisplayName("Should return successful order creation")
    void shouldReturnSuccessfulOrderCreation() {
        UUID productId = UUID.randomUUID();
        CreateOrderRequest request = new CreateOrderRequest("123", List.of(new OrderItemRequest(productId, 1, "")));
        when(customersRepository.findCustomer("123")).thenReturn(Optional.of(new Customer(
                UUID.randomUUID(),
                "John Doe",
                "123",
                "john.doe@mail.com"
        )));
        when(productsRepository.getById(productId)).thenReturn(Optional.of(new Product(
                productId,
                "X - Bacon Egg",
                BigDecimal.valueOf(27.9),
                Category.SNACK
        )));

        sut.create(request);

        verify(ordersRepository).save(any(Order.class));
    }
}