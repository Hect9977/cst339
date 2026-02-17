package com.gcu.business;

import java.util.List;

import com.gcu.model.OrderModel;

public interface OrdersBusinessServiceInterface {
    void test();
    List<OrderModel> getOrders();

    // Part 2
    void init();
    void destroy();
}
