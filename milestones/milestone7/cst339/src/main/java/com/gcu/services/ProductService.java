package com.gcu.services;

import java.util.List;

import com.gcu.models.Product;
import com.gcu.models.ProductForm;

public interface ProductService {
    Product create(ProductForm form);
    List<Product> findAll();
}
