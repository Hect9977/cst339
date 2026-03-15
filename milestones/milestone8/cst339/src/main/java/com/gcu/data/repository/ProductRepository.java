package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.ProductEntity;

// ProductRepository interface for performing CRUD operations on the PRODUCTS table
/**
 * Repository interface for CRUD access to product data.
 */
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    @Query("SELECT * FROM PRODUCTS") // OK for JDBC
    List<ProductEntity> findAllProducts();
}