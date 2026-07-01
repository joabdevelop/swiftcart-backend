package com.joabdevelop.swiftcart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.joabdevelop.swiftcart.entities.Category;
import com.joabdevelop.swiftcart.repositories.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }

}
