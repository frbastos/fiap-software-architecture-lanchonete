package com.fiap.lanchonete.domain.orders.entities;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.fiap.lanchonete.domain.customers.entities.Customer;
import com.fiap.lanchonete.domain.orders.valueobjects.OrderState;
import com.fiap.lanchonete.domain.orders.valueobjects.PaymentConfirmationStatus;
import com.fiap.lanchonete.domain.payment.entities.Payment;

public class Order {

    private UUID id;
    private Customer customer;
    private List<OrderItem> items;
    private OrderState state;
    private BigDecimal totalPrice;
    private PaymentConfirmationStatus paymentConfirmationStatus;
    private Payment payment;

    public Order(
        UUID id, 
        Customer customer, 
        List<OrderItem> items, 
        OrderState state, 
        BigDecimal totalPrice, 
        PaymentConfirmationStatus paymentConfirmationStatus, 
        Payment payment) {

        this.id = id;
        this.customer = customer;
        this.items = items;
        this.state = state;
        this.totalPrice = totalPrice;
        this.paymentConfirmationStatus = paymentConfirmationStatus;
        this.payment = payment;
    }

    public Order(
        UUID id, 
        Customer customer, 
        List<OrderItem> items, 
        OrderState state, 
        BigDecimal totalPrice, 
        PaymentConfirmationStatus paymentConfirmationStatus) {

        this.id = id;
        this.customer = customer;
        this.items = items;
        this.state = state;
        this.totalPrice = totalPrice;
        this.paymentConfirmationStatus = paymentConfirmationStatus;
    }

    public Order(
            UUID id,
            Customer customer,
            List<OrderItem> items) {

        this(id, customer, items, OrderState.PENDING, BigDecimal.ZERO, PaymentConfirmationStatus.PENDING, null);
        this.totalPrice = calculateTotalPrice(items);
    }

    public UUID getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public OrderState getState() {
        return state;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    private BigDecimal calculateTotalPrice(List<OrderItem> items) {
        return items.stream()
                .map(OrderItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void updateState(OrderState state) {
        if(state.equals(OrderState.PENDING)){
            throw new IllegalArgumentException("Prohibited forcing status update to pending");
        }
        this.state = state;
    }

    public Payment getPayment() {
        return this.payment;
    }

    public PaymentConfirmationStatus getPaymentConfirmationStatus() {
        return paymentConfirmationStatus;
    }

    private void paymentConfirmed(Payment payment) {
        this.payment = payment;
        this.paymentConfirmationStatus = PaymentConfirmationStatus.APPROVED;
        this.state = OrderState.RECEIVED;
    }

    private void paymentRefused() {
        this.payment = null;
        this.paymentConfirmationStatus = PaymentConfirmationStatus.REFUSED;
        this.state = OrderState.PENDING;
    }

    public void processPayment(Payment payment){
        if(payment != null){
            if(payment.isApproved()){
                paymentConfirmed(payment);
            }else{
                paymentRefused();
            }
        }else{
            this.paymentConfirmationStatus = PaymentConfirmationStatus.PENDING;
        }
    }
    
}
