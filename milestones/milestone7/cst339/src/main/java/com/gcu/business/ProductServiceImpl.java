package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gcu.data.entity.ProductEntity;
import com.gcu.data.repository.ProductRepository;

// ProductServiceImpl implements ProductService using Spring Data JDBC for database operations/ 
@Service
public class ProductServiceImpl implements ProductService {

    // Dependency injection of ProductRepository
    private final ProductRepository productRepository;

    // Constructor injection of ProductRepository
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Return all products from the database
    @Override
    public List<ProductEntity> findAll() {
        List<ProductEntity> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    // Create a new product in the database
    @Override
    public boolean create(ProductEntity product) {
        productRepository.save(product);
        return true;
    }

    // ---> ADDED for Milestone 5: find one product by ID
    @Override
    public ProductEntity findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // ---> ADDED for Milestone 5: update product (save with ID updates row)
    @Override
    public boolean update(ProductEntity product) {
        productRepository.save(product);
        return true;
    }

    // ---> ADDED for Milestone 5: delete product by ID
    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}