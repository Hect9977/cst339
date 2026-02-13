package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.ProductEntity;

// ProductRepository interface for performing CRUD operations on the PRODUCTS table
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    // Custom query to retrieve all products from the PRODUCTS table
    @Query("SELECT * FROM PRODUCTS")
    List<ProductEntity> findAllProducts();
}
