package com.gcu.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.OrderBusinessService;
import com.gcu.models.OrderModel;

// This class is a REST controller that handles HTTP requests related to orders. It uses the OrderBusinessService to retrieve order data and returns it in JSON format.
@RestController
@RequestMapping("/service")
public class OrderRestService {

    // The OrderBusinessService is injected into this controller to allow it to
    // access the business logic for handling orders.
    private final OrderBusinessService service;

    // Constructor for OrderRestService that takes an OrderBusinessService as a
    // parameter. This allows Spring to inject the service when creating an instance
    // of this controller.
    public OrderRestService(OrderBusinessService service) {
        this.service = service;
    }

    // This method handles GET requests to the "/orders" endpoint. It retrieves all
    // orders using the OrderBusinessService and returns them as a JSON response. If
    // an error occurs, it returns an error message with an appropriate HTTP status
    // code.
    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?> getOrders() {
        try {
            List<OrderModel> orders = service.getAllOrders();
            return new ResponseEntity<List<OrderModel>>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error getting orders", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
