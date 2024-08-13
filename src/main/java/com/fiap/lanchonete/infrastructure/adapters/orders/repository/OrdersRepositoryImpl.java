package com.fiap.lanchonete.infrastructure.adapters.orders.repository;

import com.fiap.lanchonete.domain.orders.models.Order;
import com.fiap.lanchonete.domain.orders.ports.out.GetAllOrdersOutputPort;
import com.fiap.lanchonete.domain.orders.ports.out.GetOrderByIdOutputPort;
import com.fiap.lanchonete.domain.orders.ports.out.SaveOrderOutputPort;
import com.fiap.lanchonete.infrastructure.adapters.orders.mappers.OrderMapper;
import com.fiap.lanchonete.shared.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class OrdersRepositoryImpl implements
        GetAllOrdersOutputPort,
        GetOrderByIdOutputPort,
        SaveOrderOutputPort
{

    @Autowired
    private OrdersRepository repository;

    @Override
    public List<Order> getAll() {
        return this.repository.findAll().stream().map(OrderMapper::toDomain).toList();
    }

    @Override
    public Optional<Order> getById(UUID id) throws NotFoundException {
        return this.repository.findById(id).map(OrderMapper::toDomain);
    }

    @Override
    public void save(Order order) {
        this.repository.save(OrderMapper.toPersistence(order));
    }

}
