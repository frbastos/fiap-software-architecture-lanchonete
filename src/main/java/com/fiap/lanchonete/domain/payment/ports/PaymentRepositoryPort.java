package com.fiap.lanchonete.domain.payment.ports;


import com.fiap.lanchonete.domain.payment.Payment;

import java.util.Optional;

public interface PaymentRepositoryPort {
    Payment save (Payment payment);


}
