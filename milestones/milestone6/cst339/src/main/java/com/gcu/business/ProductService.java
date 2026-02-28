package com.gcu.business;

import java.util.List;

import com.gcu.data.entity.ProductEntity;

public interface ProductService {

    List<ProductEntity> findAll();

    boolean create(ProductEntity product);

    // ---> ADDED for Milestone 5: display one product
    ProductEntity findById(Long id);

    // ---> ADDED for Milestone 5: update product
    boolean update(ProductEntity product);

    // ---> ADDED for Milestone 5: delete product
    void deleteById(Long id);
}