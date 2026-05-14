package com.minishop.maruti.repository;

import com.minishop.maruti.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository
        extends JpaRepository<Product, Long> {

    List<Product> findByTitleContainingIgnoreCase(
            String title
    );
}
