package com.fiap.lanchonete.application.products.adapters.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.lanchonete.domain.products.Category;
import com.fiap.lanchonete.domain.products.dto.ProductPersistence;
import com.fiap.lanchonete.domain.products.dto.ProductResponse;
import com.fiap.lanchonete.domain.products.dto.ProductUpdate;
import com.fiap.lanchonete.domain.products.ports.ProductServicePort;
import com.fiap.lanchonete.shared.exception.NotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("products")
public class ProductsResource {

    private final ProductServicePort productService;

    public ProductsResource(ProductServicePort productService) {
        this.productService = productService;
    }

    @PostMapping("")
    public ProductResponse saveProduct(@Valid @RequestBody ProductPersistence persistence) {
        return this.productService.save(persistence);
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable("id") UUID id, @Valid @RequestBody ProductUpdate update) {
        return this.productService.update(id, update);
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable("id") UUID id) {
        return this.productService.getById(id).orElseThrow(NotFoundException::new);
    }

    @GetMapping("")
    public List<ProductResponse> getAllProducts(
        @RequestParam(value = "category", required = false) Category category
    ){
        if(category != null){
            return this.productService.getAllByCategory(category);
        }
        return this.productService.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeProduct(@PathVariable("id") UUID id) {
        this.productService.remove(id);
        return ResponseEntity.ok().build();
    }

}
