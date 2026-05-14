package com.minishop.maruti.controller;
import com.minishop.maruti.entity.Product;
import com.minishop.maruti.service.ProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor

@CrossOrigin("*") // For allowing connection getting established and authorized from different ports or url

public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(
            @PathVariable Long id
    ) {
        return productService.getProductById(id);
    }

    @GetMapping("/search")
    public List<Product> searchProducts(
            @RequestParam String q
    ) {
        return productService.searchProducts(q);
    }

    @PostMapping
    public Product createProduct(
            @RequestBody Product product
    ) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(
            @PathVariable Long id,
            @RequestBody Product product
    ) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(
            @PathVariable Long id
    ) {
        productService.deleteProduct(id);
    }
}
