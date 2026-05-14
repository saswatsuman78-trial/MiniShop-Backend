package com.minishop.maruti.config;


import com.minishop.maruti.dto.DummyProduct;

import com.minishop.maruti.dto.DummyProductsResponse;

import com.minishop.maruti.entity.Product;

import com.minishop.maruti.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor

public class DataSeeder
        implements CommandLineRunner {

    private final ProductRepository
            productRepository;

    private final RestTemplate restTemplate;

    @Override
    public void run(String... args)
            throws Exception {

        if(productRepository.count() > 0) {
            System.out.println(
                    "Database already seeded"
            );

            return;
        }

        String url =
                "https://dummyjson.com/products?limit=100";

        DummyProductsResponse response =
                restTemplate.getForObject(
                        url,
                        DummyProductsResponse.class
                );

        if(response == null ||
                response.getProducts() == null) {

            System.out.println(
                    "Failed to fetch products"
            );

            return;
        }

        for(DummyProduct dto :
                response.getProducts()) {

            Product product =
                    Product.builder()
                            .id(dto.getId())
                            .title(dto.getTitle())
                            .description(
                                    dto.getDescription()
                            )
                            .category(
                                    dto.getCategory()
                            )
                            .price(dto.getPrice())
                            .discountPercentage(
                                    dto.getDiscountPercentage()
                            )
                            .rating(dto.getRating())
                            .stock(dto.getStock())
                            .brand(dto.getBrand())
                            .thumbnail(
                                    dto.getThumbnail()
                            )
                            .build();

            productRepository.save(product);
        }

        System.out.println(
                "Products seeded successfully"
        );
    }
}
