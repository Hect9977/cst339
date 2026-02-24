package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

// This class represents the Order document that will be stored in MongoDB.
@Document(collection = "orders")
public class OrderEntity {

    // The @Id annotation indicates that this field is the primary key in MongoDB.
    @Id
    private String id;

    // Unique index for order number
    @Indexed(unique = true)
    private String orderNo;

    // Unique index for product name
    @Indexed(unique = true)
    private String productName;

    private float price;
    private int quantity;

    // Default constructor required by Spring Data MongoDB
    public OrderEntity() {
    }

    // Parameterized constructor
    public OrderEntity(String id, String orderNo, String productName, float price, int quantity) {
        this.id = id;
        this.orderNo = orderNo;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
