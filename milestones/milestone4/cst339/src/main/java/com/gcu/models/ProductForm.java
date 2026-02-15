package com.gcu.models;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductForm {

    // Name field with validation to ensure it is not blank
    @NotBlank
    private String name;

    // Description field with validation to ensure it is not blank
    @NotBlank
    private String description;

    // Price field with validation to ensure it is not null and greater than 0
    @NotNull
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    private BigDecimal price;

    // Quantity field with validation to ensure it is greater than or equal to 0
    @Min(value = 0, message = "Quantity cannot be negative")
    private int quantity;

    // Getters and setters for all fields
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
