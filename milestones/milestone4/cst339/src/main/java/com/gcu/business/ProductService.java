package com.gcu.business;

import java.util.List;

import com.gcu.data.entity.ProductEntity;

// ProductService interface defining methods for retrieving all products and creating a new product
public interface ProductService {
    List<ProductEntity> findAll();
    boolean create(ProductEntity product);
}
