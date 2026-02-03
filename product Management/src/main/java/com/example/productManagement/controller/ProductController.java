package com.example.productManagement.controller;

import com.example.productManagement.model.ProductModel;
import com.example.productManagement.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ProductModel create( @Valid @RequestBody ProductModel product) {
        return service.create(product);
    }

    @GetMapping
    public List<ProductModel> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ProductModel getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public ProductModel update(@PathVariable String id,
                               @RequestBody ProductModel product) {
        return service.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
