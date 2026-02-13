package com.gcu.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gcu.models.Product;
import com.gcu.models.ProductForm;

// This is Spring Core IoC: Spring creates the @Service bean and injects it where needed.
@Service
public class InMemoryProductService implements ProductService {

    private final List<Product> products = new ArrayList<>();

    // Constructor to add some initial products
    @Override
    public Product create(ProductForm form) {
        Product p = new Product(
                form.getName(),
                form.getDescription(),
                form.getPrice(),
                form.getQuantity()
        );
        products.add(p);
        return p;
    }

    // Return all products
    @Override
    public List<Product> findAll() {
        return products;
    }
}
