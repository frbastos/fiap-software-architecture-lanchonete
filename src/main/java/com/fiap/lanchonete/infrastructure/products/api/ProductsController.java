package com.fiap.lanchonete.infrastructure.products.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
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
public class ProductsController implements ProdutApi {

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
        RemoveProductUseCase removeProductUseCase){

        this.productDTOMapper = productDTOMapper;
        this.productCommandMapper = productCommandMapper;
        this.createProductUseCase = createProductUseCase;
        this.updateProductUseCase = updateProductUseCase;
        this.getProductByIdUseCase = getProductByIdUseCase;
        this.getProductsByCategoryUseCase = getProductsByCategoryUseCase;
        this.getAllProductsUseCase = getAllProductsUseCase;
        this.removeProductUseCase = removeProductUseCase;
    }

    @Override
    public ProductResponse createProduct(CreateProductRequest request) {
        Product productObjDomain = productDTOMapper.toProduct(request);
        Product product = createProductUseCase.createProduct(productObjDomain);
        return productDTOMapper.toResponse(product);
    }

    @Override
    public ProductResponse updateProduct(UUID id, UpdateProductRequest update) {
        UpdateProductCommand updateCommand = productCommandMapper.toUpdateCommand(id, update);
        Product product = updateProductUseCase.update(updateCommand);
        return productDTOMapper.toResponse(product);
    }

    @Override
    public Product getProductById(UUID id) {
        return this.getProductByIdUseCase.getById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Product> getAllProducts(Category category) {
        if (category != null) {
            return getProductsByCategoryUseCase.getByCategory(category);
        }
        return getAllProductsUseCase.getAll();
    }

    @Override
    public ResponseEntity<?> removeProduct(UUID id) {
        removeProductUseCase.remove(id);
        return ResponseEntity.ok().build();
    }

}
