package com.fiap.lanchonete.domain.orders.services;

import com.fiap.lanchonete.domain.customers.Customer;
import com.fiap.lanchonete.domain.customers.ports.CustomerRepositoryPort;
import com.fiap.lanchonete.domain.orders.dtos.CreateOrderRequest;
import com.fiap.lanchonete.domain.orders.entities.Order;
import com.fiap.lanchonete.domain.orders.entities.OrderItem;
import com.fiap.lanchonete.domain.orders.ports.OrderServicePort;
import com.fiap.lanchonete.domain.orders.ports.OrdersRepositoryPort;
import com.fiap.lanchonete.domain.products.Product;
import com.fiap.lanchonete.domain.products.ports.ProductRepositoryPort;
import com.fiap.lanchonete.shared.exception.NotFoundException;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class OrderService implements OrderServicePort {

    private final CustomerRepositoryPort customersRepository;
    private final ProductRepositoryPort productsRepository;
    private final OrdersRepositoryPort ordersRepository;

    public OrderService(
            CustomerRepositoryPort customersRepository,
            ProductRepositoryPort productsRepository,
            OrdersRepositoryPort ordersRepository
    ) {
        this.customersRepository = customersRepository;
        this.productsRepository = productsRepository;
        this.ordersRepository = ordersRepository;
    }

    @Override
    public void create(CreateOrderRequest request) {
        Customer customer = request.customerDocument().isEmpty() ? null : customersRepository.findCustomer(request.customerDocument()).orElse(null);
        if (customer == null) {
            throw new NotFoundException(String.format("Customer with document '%s' not found", request.customerDocument()));
        }

        Map<UUID, Product> products = request.items().stream()
                .map(item -> productsRepository.getById(item.productId()))
                .filter(Optional::isPresent)
                .collect(Collectors.toMap(
                        item -> item.get().getId(),
                        Optional::get,
                        (a, b) -> a
                ));

        List<OrderItem> orderItems = request.items().stream()
                .parallel()
                .map(item -> {
                    Product product = products.get(item.productId());
                    if (product == null) {
                        throw new NotFoundException(String.format("Product with ID '%s' not found", item.productId()));
                    }
                    return OrderItem.create(product, item.quantity(), item.observation());
                })
                .toList();

        Order order = Order.create(Optional.of(customer), orderItems);
        ordersRepository.save(order);
    }

}
