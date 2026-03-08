package com.gcu.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.ProductService;
import com.gcu.data.entity.ProductEntity;
import com.gcu.models.api.ProductListResponse;

// REST controller for Milestone 7 product APIs.

// REST API 1: ProductListReposne object containing a list of all products in the database. The API should be able to return either JSON or XML based on the request's "Accept" header.

// REST API 2: Return one desired product by ID. The API should be able to return either JSON or XML based on the request's "Accept" header. If the product is not found, return an appropriate HTTP status code (e.g., 404 Not Found).
@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ProductListResponse getAllProducts() {
        return new ProductListResponse(productService.findAll());
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<ProductEntity> getProductById(@PathVariable Long id) {
        ProductEntity product = productService.findById(id);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(product);
    }
}
