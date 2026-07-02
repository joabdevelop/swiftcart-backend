package com.joabdevelop.swiftcart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.joabdevelop.swiftcart.entities.Product;
import com.joabdevelop.swiftcart.repositories.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

}
