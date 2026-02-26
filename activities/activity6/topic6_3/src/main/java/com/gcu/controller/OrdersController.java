package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.model.OrderModel;

@Controller
public class OrdersController {

    @Autowired
    private OrdersBusinessServiceInterface service;

    @GetMapping("/orders/display")
    public String displayOrders(Model model) {

        // call business services (optional if you need it)
        service.test();

        // get orders from the business service
        List<OrderModel> orders = service.getOrders();

        model.addAttribute("title", "My Orders");
        model.addAttribute("orders", orders);

        return "orders";
    }
}