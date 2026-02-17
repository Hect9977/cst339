package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.model.OrderModel;

@RestController
public class OrdersRestController {

    @Autowired
    private OrdersBusinessServiceInterface service;

    // JSON endpoint
    @GetMapping(value = "/getjson", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderModel> getJson() {
        return service.getOrders();
    }

    // XML endpoint
    @GetMapping(value = "/getxml", produces = MediaType.APPLICATION_XML_VALUE)
    public List<OrderModel> getXml() {
        return service.getOrders();
    }
}
