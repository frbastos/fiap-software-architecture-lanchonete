package com.fiap.lanchonete.domain.orders.usecases;

import java.util.List;

import com.fiap.lanchonete.domain.customers.models.Customer;
import com.fiap.lanchonete.domain.customers.ports.out.FindCustomerOutputPort;
import com.fiap.lanchonete.domain.orders.models.Order;
import com.fiap.lanchonete.domain.orders.models.OrderItem;
import com.fiap.lanchonete.domain.orders.models.OrderItemPersistence;
import com.fiap.lanchonete.domain.orders.models.OrderPersistence;
import com.fiap.lanchonete.domain.orders.ports.in.CreateOrderInputPort;
import com.fiap.lanchonete.domain.orders.ports.out.SaveOrderOutputPort;
import com.fiap.lanchonete.domain.payment.models.PaymentPersistence;
import com.fiap.lanchonete.domain.payment.ports.in.CreatePaymentInputPort;
import com.fiap.lanchonete.domain.products.models.Product;
import com.fiap.lanchonete.domain.products.ports.out.GetProductByIdOutputPort;
import com.fiap.lanchonete.shared.exception.NotFoundException;
import com.fiap.lanchonete.shared.validations.StringValidator;

public class CreateOrderUseCase implements CreateOrderInputPort {

    private final SaveOrderOutputPort ordersRepository;
    private final CreatePaymentInputPort createPaymentInputPort;
    private final GetProductByIdOutputPort getProductByIdOutputPort;
    private final FindCustomerOutputPort findCustomerOutputPort;

    public CreateOrderUseCase(
            SaveOrderOutputPort ordersRepository, 
            CreatePaymentInputPort createPaymentInputPort,
            GetProductByIdOutputPort getProductByIdOutputPort,
            FindCustomerOutputPort findCustomerOutputPort) {
        this.ordersRepository = ordersRepository;
        this.createPaymentInputPort = createPaymentInputPort;
        this.getProductByIdOutputPort = getProductByIdOutputPort;
        this.findCustomerOutputPort = findCustomerOutputPort;
    }

    @Override
    public void createOrder(OrderPersistence persistence) {

        Customer customer = getCustomer(persistence.document());

        List<OrderItem> ordersItem = createOrdersItens(persistence.items());

        Order order = new Order(
            null, 
            customer, 
            ordersItem);

        order = this.ordersRepository.saveAndFlush(order);
        
        //Fake Checkout
        PaymentPersistence  paymentPersistence = new PaymentPersistence(order.getTotalPrice(),order.getId());
        this.createPaymentInputPort.createPayment(paymentPersistence);
    }

    private Customer getCustomer(String document) {
        if(StringValidator.isNullOrEmpty(document)) return null;
        return findCustomerOutputPort.findCustomer(document).get();
    }

    private List<OrderItem> createOrdersItens(List<OrderItemPersistence> items) {

        return items.stream().map(item -> {
            Product findProduct = getProductByIdOutputPort.getById(item.productId())
                    .orElseThrow(() -> new NotFoundException("Product not find with ID: " + item.productId()));

            return new OrderItem(
                    null,
                    findProduct,
                    item.quantity(),
                    item.observation());

        }).toList();
    }

}
