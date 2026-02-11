package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;

// This class is used to wrap a list of OrderModel objects for XML serialization
@XmlRootElement(name="orders")
public class OrderList {

    // List to hold OrderModel objects
    private List<OrderModel> orders = new ArrayList<>();
    
    // Getter and Setter methods for the orders list
    public List<OrderModel> getOrders() {
        return orders;
    }
    // Setter method to set the orders list
    public void setOrders(List<OrderModel> orders) {
        this.orders = orders;
    }
}
