package com.gcu.services;

import java.util.List;

import com.gcu.models.Product;
import com.gcu.models.ProductForm;

/**
 * Defines product-related business operations used by controllers and APIs.
 */
public interface ProductService {
    Product create(ProductForm form);
    List<Product> findAll();
}
