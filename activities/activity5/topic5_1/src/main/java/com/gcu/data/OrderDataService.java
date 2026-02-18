package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;

@Service
public class OrderDataService implements DataAccessInterface<OrderEntity> {

    // Injecting the OrdersRepository using constructor injection
    @Autowired
    private final OrdersRepository ordersRepository;

    // Constructor injection required by the activity
    public OrderDataService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    // Implementing the DataAccessInterface methods
    @Override
    public OrderEntity findById(String id) {
        try {
            return ordersRepository.getOrderById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // This method is not required by the activity, but it's a common method in data
    // access services
    @Override
    public List<OrderEntity> findAll() {
        List<OrderEntity> orders = new ArrayList<>();
        try {
            Iterable<OrderEntity> orderIterable = ordersRepository.findAll();
            orderIterable.forEach(orders::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    // The create method is required by the activity, and it should return true even
    // if an exception occurs
    @Override
    public boolean create(OrderEntity order) {
        try {
            ordersRepository.save(order);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true; // per your activity instructions
        }
    }

    // The update and delete methods are required by the activity, but they should
    // return true without performing any operations
    @Override
    public boolean update(OrderEntity t) {
        return true;
    }

    // The delete method is required by the activity, but it should return true
    // without performing any operations
    @Override
    public boolean delete(OrderEntity t) {
        return true;
    }
}
