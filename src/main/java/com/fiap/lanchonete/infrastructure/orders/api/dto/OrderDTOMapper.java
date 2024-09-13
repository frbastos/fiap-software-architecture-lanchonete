package com.fiap.lanchonete.infrastructure.orders.api.dto;

import com.fiap.lanchonete.domain.orders.entities.Order;
import com.fiap.lanchonete.infrastructure.customers.api.dto.CustomerDTOMapper;

public class OrderDTOMapper {

    private final CustomerDTOMapper customerDTOMapper;

    public OrderDTOMapper(CustomerDTOMapper customerDTOMapper) {
        this.customerDTOMapper = customerDTOMapper;
    }

    public OrderResponse toOrderResponse(Order order) {
        return new OrderResponse(order.getId(), customerDTOMapper.toResponse(order.getCustomer()), order.getState(),
                order.getTotalPrice(), order.getPaymentConfirmationStatus());
    }

}
