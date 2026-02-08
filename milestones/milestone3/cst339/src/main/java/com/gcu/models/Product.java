package com.gcu.models;

import java.util.UUID;

// Product model class
public class Product {
    private final String id;
    private final String name;
    private final String description;
    private final int price;
    private final int quantity;

    // Constructor to create a new product with a unique ID
    public Product(String name, String description, int price, int quantity) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters for all fields
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getPrice() { return price; }
    public int getQuantity() { return quantity; }
}
