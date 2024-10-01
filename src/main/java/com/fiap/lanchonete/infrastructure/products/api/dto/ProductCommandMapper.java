package com.fiap.lanchonete.infrastructure.products.api.dto;

import com.fiap.lanchonete.application.products.usecases.commands.UpdateProductCommand;

public class ProductCommandMapper {

    public UpdateProductCommand toUpdateCommand(Long id, UpdateProductRequest request){
        return new UpdateProductCommand(id, request.description(), request.price(), request.category());
    }

}
