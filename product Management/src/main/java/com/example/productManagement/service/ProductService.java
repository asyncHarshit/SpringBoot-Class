package com.example.productManagement.service;

import com.example.productManagement.model.ProductModel;
import com.example.productManagement.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductModel create(ProductModel product) {
        if (repository.existsByName(product.name())) {
            throw new RuntimeException("Product already exists");
        }
        return repository.save(product);
    }

    public List<ProductModel> getAll() {
        return repository.findAll();
    }


    public ProductModel getById(String id) {    
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public ProductModel update(String id, ProductModel updated) {
        ProductModel existing = getById(id);

        ProductModel newProduct = new ProductModel(
                existing.id(),
                updated.name(),
                updated.description(),
                updated.price(),
                updated.stock()
        );

        return repository.save(newProduct);
    }

    public void delete(String id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        repository.deleteById(id);
    }
}
