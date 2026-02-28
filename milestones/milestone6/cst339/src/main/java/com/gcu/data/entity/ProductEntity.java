package com.gcu.data.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

// Product entity class representing the PRODUCTS table in the database
@Table("PRODUCTS")
public class ProductEntity {

    @Id
    private Long id;

    @Column("NAME")
    private String name;

    @Column("DESCRIPTION")
    private String description;

    @Column("PRICE")
    private BigDecimal price;

    @Column("QUANTITY")
    private int quantity;

    // Default constructor
    public ProductEntity() {
    }

    // Constructor with all fields
    public ProductEntity(Long id, String name, String description, BigDecimal price, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters for all fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}