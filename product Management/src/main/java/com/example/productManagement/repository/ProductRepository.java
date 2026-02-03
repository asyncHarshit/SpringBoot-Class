package com.example.productManagement.repository;

import com.example.productManagement.model.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository
        extends MongoRepository<ProductModel, String> {

    boolean existsByName(String name);
}
