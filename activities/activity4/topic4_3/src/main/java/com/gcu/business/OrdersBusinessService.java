package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.OrderDataService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;

public class OrdersBusinessService implements OrdersBusinessServiceInterface {

    @Autowired
    private OrderDataService service;

    @Override
    public void test() {
        System.out.println("Hello from the OrdersBusinessService");
    }

    @Override
    public List<OrderModel> getOrders() {

        // call the data service to get the list of OrderEntity objects
        List<OrderEntity> ordersEntity = service.findAll();

        // domain list that will be returned to the presentation layer
        List<OrderModel> ordersDomain = new ArrayList<>();

        // convert each OrderEntity -> OrderModel
        for (OrderEntity e : ordersEntity) {
            ordersDomain.add(new OrderModel(
                e.getId(),
                e.getOrderNo(),
                e.getProductName(),
                e.getPrice(),
                e.getQuantity()
            ));
        }

        // return domain list (no persistence annotations leak into UI)
        return ordersDomain;
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
