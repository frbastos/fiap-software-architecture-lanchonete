package com.fiap.lanchonete.application.orders.usecases;

import com.fiap.lanchonete.application.customers.usecases.FindCustomerUseCase;
import com.fiap.lanchonete.application.orders.gateways.OrderGateway;
import com.fiap.lanchonete.application.payment.usecases.CreatePaymentUseCase;
import com.fiap.lanchonete.application.products.usecases.GetProductByIdUseCase;
import com.fiap.lanchonete.domain.customers.entities.Customer;
import com.fiap.lanchonete.domain.orders.entities.Order;
import com.fiap.lanchonete.domain.orders.entities.OrderItem;
import com.fiap.lanchonete.domain.products.entities.Product;
import com.fiap.lanchonete.infrastructure.orders.api.dto.OrderItemRequest;
import com.fiap.lanchonete.infrastructure.orders.api.dto.OrderRequest;
import com.fiap.lanchonete.shared.exception.NotFoundException;
import com.fiap.lanchonete.shared.validations.StringValidator;

import java.util.List;


public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

    private final OrderGateway orderGateway;
    private final FindCustomerUseCase findCustomerUseCase;
    private final GetProductByIdUseCase getProductByIdUseCase;

    public CreateOrderUseCaseImpl(
            OrderGateway orderGateway,
            CreatePaymentUseCase createPaymentUseCase,
            FindCustomerUseCase findCustomerUseCase,
            GetProductByIdUseCase getProductByIdUseCase
            ) {

        this.orderGateway = orderGateway;
        this.getProductByIdUseCase = getProductByIdUseCase;
        this.findCustomerUseCase = findCustomerUseCase;

    }

    @Override
    public Order createOrder(OrderRequest persistence) {

        Customer customer = getCustomer(persistence.document());

        List<OrderItem> ordersItem = createOrdersItens(persistence.items());

        Order order = new Order(
                null,
                customer,
                ordersItem,
                orderGateway.getOrderNumber());

        return orderGateway.saveAndFlush(order);
    }

    private Customer getCustomer(String document) {
        if (StringValidator.isNullOrEmpty(document)) return null;
        return findCustomerUseCase.findCustomer(document).get();
    }

    private List<OrderItem> createOrdersItens(List<OrderItemRequest> items) {

        return items.stream().map(item -> {
            Product findProduct = getProductByIdUseCase.getById(item.productId())
                    .orElseThrow(() -> new NotFoundException("Product not find with ID: " + item.productId()));

            return new OrderItem(
                    null,
                    findProduct,
                    item.quantity(),
                    item.observation());

        }).toList();
    }
}
