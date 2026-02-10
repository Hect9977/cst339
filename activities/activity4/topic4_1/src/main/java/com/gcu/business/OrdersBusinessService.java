package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.DataAccessInterface;
import com.gcu.model.OrderModel;

// Business Service class that implements the OrdersBusinessServiceInterface
public class OrdersBusinessService implements OrdersBusinessServiceInterface {

    // Autowiring the DataAccessInterface to access order data
    @Autowired
    private DataAccessInterface<OrderModel> service;

    // Default constructor
    @Override
    public void test() {
        System.out.println("Hello from the OrdersBusinessService");
    }

    // Method to retrieve all orders using the data access service
    @Override
    public List<OrderModel> getOrders() {
        return service.findAll();
    }

    // Method to create a new order using the data access service
    @Override
    public void init() {
        System.out.println("OrdersBusinessService.init() called");
    }

    // Method to clean up resources when the service is destroyed
    @Override
    public void destroy() {
        System.out.println("OrdersBusinessService.destroy() called");
    }
}
