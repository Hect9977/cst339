package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.OrderList;
import com.gcu.model.OrderModel;

// RESTful service to provide order data in JSON and XML formats
@RestController
@RequestMapping("/service")
public class OrdersRestService {

    // Injecting the OrdersBusinessServiceInterface to access order data
    @Autowired
    private OrdersBusinessServiceInterface service;

    // Endpoint to get orders in JSON format
    @GetMapping(path = "/getjson", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderModel> getOrdersAsJson() {
        return service.getOrders();
    }

    // Endpoint to get orders in XML format
    @GetMapping(path = "/getxml", produces = MediaType.APPLICATION_XML_VALUE)
    public OrderList getOrdersAsXml() {
        OrderList list = new OrderList();
        list.setOrders(service.getOrders());
        return list;
    }
}
