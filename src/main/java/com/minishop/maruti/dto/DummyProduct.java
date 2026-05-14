package com.minishop.maruti.dto;

import lombok.Data;

@Data

public class DummyProduct {

    private Long id;

    private String title;

    private String description;

    private String category;

    private Double price;

    private Double discountPercentage;

    private Double rating;

    private Integer stock;

    private String brand;

    private String thumbnail;
}