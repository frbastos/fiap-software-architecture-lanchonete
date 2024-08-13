package com.fiap.lanchonete.domain.products.ports.out;

import java.util.UUID;

public interface RemoveProductOutputPort {

    void remove(UUID id);
    
}
