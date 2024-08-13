package com.fiap.lanchonete.infrastructure.adapters.payment.repository;

import com.fiap.lanchonete.infrastructure.adapters.payment.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<PaymentEntity, UUID> {
}
