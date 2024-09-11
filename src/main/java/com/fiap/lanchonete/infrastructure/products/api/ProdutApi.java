package com.fiap.lanchonete.infrastructure.products.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fiap.lanchonete.domain.products.entities.Product;
import com.fiap.lanchonete.domain.products.valueobjects.Category;
import com.fiap.lanchonete.infrastructure.products.api.dto.CreateProductRequest;
import com.fiap.lanchonete.infrastructure.products.api.dto.ProductResponse;
import com.fiap.lanchonete.infrastructure.products.api.dto.UpdateProductRequest;

@RequestMapping(value = "products")
public interface ProdutApi {

    @PostMapping("")
    ProductResponse createProduct(@RequestBody CreateProductRequest request);

    @PutMapping("/{id}")
    ProductResponse updateProduct(@PathVariable("id") UUID id, @RequestBody UpdateProductRequest update);

    @GetMapping("/{id}")
    Product getProductById(@PathVariable("id") UUID id);
    
    @GetMapping("")
    List<Product> getAllProducts( @RequestParam(value = "category", required = false) Category category);

    ResponseEntity<?> removeProduct(@PathVariable("id") UUID id);

}
