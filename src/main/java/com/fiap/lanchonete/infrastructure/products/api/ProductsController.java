package com.fiap.lanchonete.infrastructure.products.api;

import java.util.List;

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

import com.fiap.lanchonete.application.products.gateways.ProductGateway;
import com.fiap.lanchonete.application.products.usecases.CreateProductUseCase;
import com.fiap.lanchonete.application.products.usecases.GetAllProductsUseCase;
import com.fiap.lanchonete.application.products.usecases.GetProductByIdUseCase;
import com.fiap.lanchonete.application.products.usecases.GetProductsByCategoryUseCase;
import com.fiap.lanchonete.application.products.usecases.RemoveProductUseCase;
import com.fiap.lanchonete.application.products.usecases.UpdateProductUseCase;
import com.fiap.lanchonete.application.products.usecases.commands.UpdateProductCommand;
import com.fiap.lanchonete.domain.products.entities.Product;
import com.fiap.lanchonete.domain.products.valueobjects.Category;
import com.fiap.lanchonete.infrastructure.products.api.dto.CreateProductRequest;
import com.fiap.lanchonete.infrastructure.products.api.dto.ProductCommandMapper;
import com.fiap.lanchonete.infrastructure.products.api.dto.ProductDTOMapper;
import com.fiap.lanchonete.infrastructure.products.api.dto.ProductResponse;
import com.fiap.lanchonete.infrastructure.products.api.dto.UpdateProductRequest;
import com.fiap.lanchonete.shared.exception.NotFoundException;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductDTOMapper productDTOMapper;
    private final ProductCommandMapper productCommandMapper;
    private final CreateProductUseCase createProductUseCase;
    private final GetProductByIdUseCase getProductByIdUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final GetProductsByCategoryUseCase getProductsByCategoryUseCase;
    private final GetAllProductsUseCase getAllProductsUseCase;
    private final RemoveProductUseCase removeProductUseCase;

    public ProductsController(
            ProductGateway productGateway,
            ProductDTOMapper productDTOMapper,
            ProductCommandMapper productCommandMapper,
            CreateProductUseCase createProductUseCase,
            UpdateProductUseCase updateProductUseCase,
            GetProductByIdUseCase getProductByIdUseCase,
            GetProductsByCategoryUseCase getProductsByCategoryUseCase,
            GetAllProductsUseCase getAllProductsUseCase,
            RemoveProductUseCase removeProductUseCase) {

        this.productDTOMapper = productDTOMapper;
        this.productCommandMapper = productCommandMapper;
        this.createProductUseCase = createProductUseCase;
        this.updateProductUseCase = updateProductUseCase;
        this.getProductByIdUseCase = getProductByIdUseCase;
        this.getProductsByCategoryUseCase = getProductsByCategoryUseCase;
        this.getAllProductsUseCase = getAllProductsUseCase;
        this.removeProductUseCase = removeProductUseCase;
    }

    @PostMapping("")
    public ProductResponse createProduct(@RequestBody CreateProductRequest request) {
        Product productObjDomain = productDTOMapper.toProduct(request);
        Product product = createProductUseCase.createProduct(productObjDomain);
        return productDTOMapper.toResponse(product);
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable("id") Long id, @RequestBody UpdateProductRequest update) {
        UpdateProductCommand updateCommand = productCommandMapper.toUpdateCommand(id, update);
        Product product = updateProductUseCase.update(updateCommand);
        return productDTOMapper.toResponse(product);
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable("id") Long id) {
        Product product = this.getProductByIdUseCase.getById(id).orElseThrow(NotFoundException::new);
        return productDTOMapper.toResponse(product);
    }

    @GetMapping("")
    public List<ProductResponse> getAllProducts(@RequestParam(value = "category", required = false) Category category) {
        List<Product> products;
        if (category != null) {
            products = getProductsByCategoryUseCase.getByCategory(category);
        }else{
            products = getAllProductsUseCase.getAll();
        }
        return products.stream().map(p -> productDTOMapper.toResponse(p)).toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeProduct(@PathVariable("id") Long id) {
        removeProductUseCase.remove(id);
        return ResponseEntity.ok().build();
    }

}
