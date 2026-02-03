package com.example.productManagement.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public record ProductModel(
        @Id String id,
        @NotBlank (message = "Name cannot be null")
        String name,
        String description,
        @Max(value = 10000 , message = "Price can't be greater than 10000") @Min(value = 0 , message = "Price can't be less than zero")
        double price,
        int stock
) {}

