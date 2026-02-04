package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.OrderModel;

public class OrdersBusinessService implements OrdersBusinessServiceInterface {

    @Override
    public void test() {
        System.out.println("Hello from the OrdersBusinessService");
    }

    @Override
    public List<OrderModel> getOrders() {
        List<OrderModel> orders = new ArrayList<>();

        orders.add(new OrderModel(Long.valueOf("0000001"), "0000001", "Product 1", 9.99f, 1));
        orders.add(new OrderModel(Long.valueOf("0000002"), "0000002", "Product 2", 19.99f, 2));
        orders.add(new OrderModel(Long.valueOf("0000003"), "0000003", "Product 3", 29.99f, 3));

        return orders;
    }
}
