package com.fiap.lanchonete.application.products.adapters.api;

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

import com.fiap.lanchonete.domain.products.models.Category;
import com.fiap.lanchonete.domain.products.models.Product;
import com.fiap.lanchonete.domain.products.models.ProductPersistence;
import com.fiap.lanchonete.domain.products.models.ProductUpdate;
import com.fiap.lanchonete.domain.products.ports.in.CreateProductInputPort;
import com.fiap.lanchonete.domain.products.ports.in.GetAllProductsInputPort;
import com.fiap.lanchonete.domain.products.ports.in.GetProductByIdInputPort;
import com.fiap.lanchonete.domain.products.ports.in.GetProductsByCategoryInputPort;
import com.fiap.lanchonete.domain.products.ports.in.RemoveProductInputPort;
import com.fiap.lanchonete.domain.products.ports.in.UpdateProductInputPort;
import com.fiap.lanchonete.shared.exception.NotFoundException;

@RestController
@RequestMapping("products")
public class ProductsApi {

    private final CreateProductInputPort createProductInputPort;
    private final GetAllProductsInputPort getAllProductsInputPort;
    private final GetProductByIdInputPort getProductByIdInputPort;
    private final GetProductsByCategoryInputPort getProductsByCategoryInputPort;
    private final RemoveProductInputPort removeProductInputPort;
    private final UpdateProductInputPort updateProductInputPort;

    public ProductsApi(CreateProductInputPort createProductInputPort, GetAllProductsInputPort getAllProductsInputPort,
            GetProductByIdInputPort getProductByIdInputPort,
            GetProductsByCategoryInputPort getProductsByCategoryInputPort,
            RemoveProductInputPort removeProductInputPort,
            UpdateProductInputPort updateProductInputPort) {
        this.createProductInputPort = createProductInputPort;
        this.getAllProductsInputPort = getAllProductsInputPort;
        this.getProductByIdInputPort = getProductByIdInputPort;
        this.getProductsByCategoryInputPort = getProductsByCategoryInputPort;
        this.removeProductInputPort = removeProductInputPort;
        this.updateProductInputPort = updateProductInputPort;
    }

    @PostMapping("")
    public Product createProduct(@RequestBody ProductPersistence persistence) {
        return this.createProductInputPort.createProduct(persistence);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") UUID id, @RequestBody ProductUpdate update) {
        return this.updateProductInputPort.update(id, update);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") UUID id) {
        return this.getProductByIdInputPort.getById(id).orElseThrow(NotFoundException::new);
    }

    @GetMapping("")
    public List<Product> getAllProducts(
            @RequestParam(value = "category", required = false) Category category) {
        if (category != null) {
            return this.getProductsByCategoryInputPort.getByCategory(category);
        }
        return this.getAllProductsInputPort.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeProduct(@PathVariable("id") UUID id) {
        this.removeProductInputPort.remove(id);
        return ResponseEntity.ok().build();
    }

}
