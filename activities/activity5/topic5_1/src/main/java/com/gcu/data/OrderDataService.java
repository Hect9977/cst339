package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;

// This class is a Spring service that implements the DataAccessInterface for OrderEntity objects, providing methods to perform CRUD operations using the OrdersRepository.
@Service
public class OrderDataService implements DataAccessInterface<OrderEntity> {

    // The OrdersRepository is injected into this service using constructor injection, allowing it to perform database operations on OrderEntity objects.
    @Autowired
    private final OrdersRepository ordersRepository;

    // Constructor injection required by the activity
    public OrderDataService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    // The findById method is currently a placeholder that returns null. It should be implemented to retrieve an OrderEntity by its ID from the database.
    @Override
    public OrderEntity findById(int id) {
        return null;
    }

    // The findAll method retrieves all OrderEntity objects from the database using the OrdersRepository and returns them as a list.
    @Override
    public List<OrderEntity> findAll() {
        // Created a list to hold the OrderEntity objects retrieved from the database.
        List<OrderEntity> orders = new ArrayList<>();

        // The findAll method of the OrdersRepository returns an Iterable of OrderEntity objects, which we iterate over and add to the orders list. If an exception occurs during this process, it is caught and printed to the console.
        try {
            Iterable<OrderEntity> orderIterable = ordersRepository.findAll();
            orderIterable.forEach(orders::add);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orders;
    }

    // The create method attempts to save a new OrderEntity to the database using the OrdersRepository. It returns true if the operation is successful, and also returns true if an exception occurs (as per the instructions).
    @Override
    public boolean create(OrderEntity order) {
        try {
            ordersRepository.save(order);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    // The update method is currently a placeholder that returns true. It should be implemented to update an existing OrderEntity in the database.
    @Override
    public boolean update(OrderEntity t) {
        return true; 
    }

    // The delete method is currently a placeholder that returns true. It should be implemented to delete an existing OrderEntity from the database.
    @Override
    public boolean delete(OrderEntity t) {
        return true; 
    }
}
