package com.joabdevelop.swiftcart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.joabdevelop.swiftcart.entities.User;
import com.joabdevelop.swiftcart.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

}
