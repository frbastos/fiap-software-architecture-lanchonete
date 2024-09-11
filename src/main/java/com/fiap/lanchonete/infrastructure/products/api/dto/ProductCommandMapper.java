package com.fiap.lanchonete.infrastructure.products.api.dto;

import java.util.UUID;

import com.fiap.lanchonete.application.products.usecases.commands.UpdateProductCommand;

public class ProductCommandMapper {

    public UpdateProductCommand toUpdateCommand(UUID id, UpdateProductRequest request){
        return new UpdateProductCommand(id, request.description(), request.price(), request.category());
    }

}
