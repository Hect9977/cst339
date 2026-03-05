package com.gcu.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.gcu.models.OrderModel;
import com.gcu.models.UserModel;

@Controller
@RequestMapping("/app")
public class TestController {

    @GetMapping({ "", "/" })
    public String home(Model model) {
        model.addAttribute("title", "Demo Microservices Application");
        return "home";
    }

    @GetMapping("/getusers")
    public String getUsers(Model model) {
        try {
            String url = "http://localhost:8081/service/users";
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<List<UserModel>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<UserModel>>() {
                    });

            List<UserModel> users = response.getBody();
            model.addAttribute("title", "List of Users");
            model.addAttribute("users", users != null ? users : Collections.emptyList());
            return "users";
        } catch (Exception e) {
            model.addAttribute("title", "List of Users");
            model.addAttribute("users", Collections.emptyList());
            model.addAttribute("errorMessage", "Could not connect to Users REST API on port 8081.");
            return "users";
        }
    }

    @GetMapping("/getorders")
    public String getOrders(Model model) {
        try {
            String url = "http://localhost:8082/service/orders";
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<List<OrderModel>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<OrderModel>>() {
                    });

            List<OrderModel> orders = response.getBody();
            model.addAttribute("title", "Orders");
            model.addAttribute("orders", orders != null ? orders : Collections.emptyList());
            return "orders";
        } catch (Exception e) {
            model.addAttribute("title", "Orders");
            model.addAttribute("orders", Collections.emptyList());
            model.addAttribute("errorMessage", "Could not connect to Orders REST API on port 8082.");
            return "orders";
        }
    }
}