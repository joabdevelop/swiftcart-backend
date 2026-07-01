package com.joabdevelop.swiftcart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joabdevelop.swiftcart.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
