package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

// This class represents the Order entity that will be stored in the database.
@Table("ORDERS")
public class OrderEntity {

    // The @Id annotation indicates that this field is the primary key of the table.
    @Id
    private Long id;

    // The @Column annotation specifies the column name in the database table that this field maps to.
    @Column("ORDER_NO")
    private String orderNo;

    // The @Column annotation specifies the column name in the database table that this field maps to.
    @Column("PRODUCT_NAME")
    private String productName;

    // The @Column annotation specifies the column name in the database table that this field maps to.
    @Column("PRICE")
    private float price;

    // The @Column annotation specifies the column name in the database table that this field maps to.
    @Column("QUANTITY")
    private int quantity;

    // Default constructor is required by Spring Data JDBC to create instances of the entity.
    public OrderEntity() { }

    // Parameterized constructor to create an OrderEntity with all fields initialized.
    public OrderEntity(Long id, String orderNo, String productName, float price, int quantity) {
        this.id = id;
        this.orderNo = orderNo;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters for all fields to allow access and modification of the entity's properties.
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOrderNo() { return orderNo; }
    public void setOrderNo(String orderNo) { this.orderNo = orderNo; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
