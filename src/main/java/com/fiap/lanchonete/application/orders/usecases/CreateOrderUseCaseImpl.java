package com.fiap.lanchonete.application.orders.usecases;

import java.math.BigInteger;
import java.util.List;

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
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

    private final OrderGateway orderGateway;
    private final FindCustomerUseCase findCustomerUseCase;
    private final GetProductByIdUseCase getProductByIdUseCase;

    @PersistenceContext
    private final EntityManager entityManager;

    public CreateOrderUseCaseImpl(
            OrderGateway orderGateway,
            CreatePaymentUseCase createPaymentUseCase,
            FindCustomerUseCase findCustomerUseCase,
            GetProductByIdUseCase getProductByIdUseCase,
            EntityManager entityManager) {

        this.orderGateway = orderGateway;
        this.getProductByIdUseCase = getProductByIdUseCase;
        this.findCustomerUseCase = findCustomerUseCase;
        this.entityManager = entityManager;
    }

    @Override
    public Order createOrder(OrderRequest persistence) {

        Customer customer = getCustomer(persistence.document());

        List<OrderItem> ordersItem = createOrdersItens(persistence.items());

        Order order = new Order(
                null,
                customer,
                ordersItem,
                generateOrderNumber());

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


    private  Long generateOrderNumber() {
        Query query = entityManager.createNativeQuery("SELECT nextval('order_sequence')");
        return (Long) query.getSingleResult();
    }


}
