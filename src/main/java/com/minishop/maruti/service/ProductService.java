package com.minishop.maruti.service;
import com.minishop.maruti.entity.Product;
import com.minishop.maruti.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));
    }

    public List<Product> searchProducts(String query) {
        return productRepository
                .findByTitleContainingIgnoreCase(query);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(
            Long id,
            Product updatedProduct
    ) {
        Product existing =
                getProductById(id);

        existing.setTitle(updatedProduct.getTitle());
        existing.setDescription(updatedProduct.getDescription());
        existing.setCategory(updatedProduct.getCategory());
        existing.setPrice(updatedProduct.getPrice());
        existing.setDiscountPercentage(
                updatedProduct.getDiscountPercentage()
        );
        existing.setRating(updatedProduct.getRating());
        existing.setStock(updatedProduct.getStock());
        existing.setBrand(updatedProduct.getBrand());
        existing.setThumbnail(updatedProduct.getThumbnail());

        return productRepository.save(existing);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}