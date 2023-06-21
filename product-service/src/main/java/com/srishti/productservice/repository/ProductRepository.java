package com.srishti.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.srishti.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{
    
}
