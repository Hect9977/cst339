package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.DataAccessInterface;
import com.gcu.model.OrderModel;

@Service
public class OrdersBusinessService implements OrdersBusinessServiceInterface {

    @Autowired
    private DataAccessInterface<OrderModel> service;

    @Override
    public void test() {
        System.out.println("Hello from the OrdersBusinessService");
    }

    @Override
    public List<OrderModel> getOrders() {
        // Part 8: Replace hard-coded list with DAO call
        return service.findAll();
    }

    @Override
    public void init() {
        System.out.println("OrdersBusinessService.init() called");
    }

    @Override
    public void destroy() {
        System.out.println("OrdersBusinessService.destroy() called");
    }
}
