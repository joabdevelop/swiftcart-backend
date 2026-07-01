package com.joabdevelop.swiftcart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joabdevelop.swiftcart.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
