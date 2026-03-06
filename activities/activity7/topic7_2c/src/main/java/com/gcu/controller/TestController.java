package com.gcu.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.gcu.models.OrderModel;
import com.gcu.models.UserModel;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

import org.springframework.http.HttpMethod;

@Controller
@RequestMapping("/app")
public class TestController {

    private final EurekaClient eurekaClient;

    public TestController(EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }

    @GetMapping({ "", "/" })
    public String home(Model model) {
        model.addAttribute("title", "Demo Microservices Application");
        return "home";
    }

    @GetMapping("/getusers")
    public String getUsers(Model model) {

        Application application = eurekaClient.getApplication("USER-SERVICE");
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String hostname = instanceInfo.getHostName();
        int port = instanceInfo.getPort();

        String url = "http://" + hostname + ":" + port + "/service/users";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<UserModel>> rateResponse = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UserModel>>() {
                });
        List<UserModel> users = rateResponse.getBody();
        model.addAttribute("title", "List of Users");
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/getorders")
    public String getOrders(Model model) {

        Application application = eurekaClient.getApplication("ORDER-SERVICE");
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String hostname = instanceInfo.getHostName();
        int port = instanceInfo.getPort();

        String url = "http://" + hostname + ":" + port + "/service/orders";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<OrderModel>> rateResponse = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<OrderModel>>() {
                });
        List<OrderModel> orders = rateResponse.getBody();
        model.addAttribute("title", "List of Orders");
        model.addAttribute("orders", orders);
        return "orders";
    }
}