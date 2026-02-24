package com.gcu.business;

import java.util.List;

import com.gcu.model.OrderModel;

// This interface defines the business service for orders, which will be implemented by the OrdersBusinessService class.
public interface OrdersBusinessServiceInterface {
    public void test();

    public List<OrderModel> getOrders();

    public OrderModel getOrderById(String id);

    void init();

    void destroy();
}
