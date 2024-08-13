package com.fiap.lanchonete.domain.products.ports.in;

import java.util.UUID;

public interface RemoveProductInputPort {

    void remove(UUID id);
    
}
