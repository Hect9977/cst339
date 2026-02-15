package com.gcu.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gcu.data.entity.ProductEntity;
import com.gcu.data.repository.ProductRepository;

// ProductServiceImpl class implementing the ProductService interface to handle product retrieval and creation logic
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductEntity> findAll() {
        return productRepository.findAllProducts();
    }

    @Override
    public boolean create(ProductEntity product) {
        productRepository.save(product);
        return true;
    }
}
