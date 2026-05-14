package com.minishop.maruti.entity;
import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "products")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Product {

    @Id
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    private String category;

    private Double price;

    private Double discountPercentage;

    private Double rating;

    private Integer stock;

    private String brand;

    private String thumbnail;
}