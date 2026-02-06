package com.gcu.models;

import java.util.UUID;

public class Product {
    private String id;
    private String name;
    private String description;
    private int price;
    private int quantity;

    public Product(String name, String description, int price, int quantity) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getPrice() { return price; }
    public int getQuantity() { return quantity; }
}
