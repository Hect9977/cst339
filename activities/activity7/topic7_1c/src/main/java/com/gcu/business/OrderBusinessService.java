package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;
import com.gcu.models.OrderModel;

// This service class contains the business logic for handling orders. It interacts with the OrdersRepository to retrieve data from MongoDB and converts it into OrderModel objects for use in the application.
@Service
public class OrderBusinessService {

    // The OrdersRepository is injected into this service to allow it to perform
    // database operations related to orders.
    private final OrdersRepository service;

    // Constructor for OrderBusinessService that takes an OrdersRepository as a
    // parameter. This allows Spring to inject the repository when creating an
    // instance of this service.
    public OrderBusinessService(OrdersRepository service) {
        this.service = service;
    }

    // This method retrieves all orders from the database, converts them from
    // OrderEntity objects to OrderModel objects, and returns a list of OrderModel
    // objects.
    public List<OrderModel> getAllOrders() {
        List<OrderEntity> entities = service.findAll();
        List<OrderModel> orders = new ArrayList<>();

        for (OrderEntity entity : entities) {
            orders.add(new OrderModel(
                    entity.getId(),
                    entity.getOrderNo(),
                    entity.getProductName(),
                    entity.getPrice(),
                    entity.getQuantity()));
        }

        return orders;
    }
}
