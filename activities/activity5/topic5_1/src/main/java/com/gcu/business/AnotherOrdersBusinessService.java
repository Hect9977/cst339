package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.OrderModel;

public class AnotherOrdersBusinessService implements OrdersBusinessServiceInterface {

    @Override
    public void test() {
        System.out.println("Hello from the anotherOrdersBusinessService");
    }

    @Override
    public List<OrderModel> getOrders() {
        List<OrderModel> orders = new ArrayList<>();

        orders.add(new OrderModel("0000001", "Product 1", "Description 1", 9.99f, 1));
        orders.add(new OrderModel("0000002", "Product 2", "Description 2", 19.99f, 2));
        orders.add(new OrderModel("0000003", "Product 3", "Description 3", 29.99f, 3));

        return orders;
    }

    // Implement init() + destroy() methods
    @Override
    public void init() {
        System.out.println("AnotherOrdersBusinessService.init() called");
    }

    @Override
    public void destroy() {
        System.out.println("AnotherOrdersBusinessService.destroy() called");
    }
}
