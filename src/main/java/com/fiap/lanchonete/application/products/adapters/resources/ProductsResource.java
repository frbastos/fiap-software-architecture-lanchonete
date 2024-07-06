package com.fiap.lanchonete.application.products.adapters.resources;

import com.fiap.lanchonete.domain.products.dto.ProductPersistence;
import com.fiap.lanchonete.domain.products.dto.ProductResponse;
import com.fiap.lanchonete.domain.products.dto.ProductUpdate;
import com.fiap.lanchonete.domain.products.ports.ProductServicePort;
import com.fiap.lanchonete.shared.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("products")
public class ProductsResource {

    private final ProductServicePort productService;

    public ProductsResource(ProductServicePort productService) {
        this.productService = productService;
    }

    @PostMapping("")
    public ResponseEntity<?> saveProduct(@Valid @RequestBody ProductPersistence persistence){
        this.productService.save(persistence);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") UUID id, @Valid @RequestBody ProductUpdate update){
        this.productService.update(id, update);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(
            @PathVariable("id") UUID id){
        return this.productService.getById(id)
                .orElseThrow(NotFoundException::new)
                .toProdutcResponse();
    }

    @GetMapping("")
    public List<ProductResponse> getAllProducts(){
        return this.productService.getAll();
    }

}
