package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private OrdersBusinessServiceInterface service;

    @Autowired
    private SecurityBusinessService security;

    @GetMapping({ "", "/" })
    public String display(Model model) {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {

        // If validation errors, go back to login
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Login Form");
            return "login";
        }

        // Printing the form values out
        System.out.println(String.format("Username: %s and Password of: %s",
                loginModel.getUsername(), loginModel.getPassword()));

        // call business services
        service.test();
        security.authenticate(loginModel.getUsername(), loginModel.getPassword());

        // get orders from the business service (no hard-coded list here)
        List<OrderModel> orders = service.getOrders();

        // Setting the model attributes
        model.addAttribute("title", "My Orders");
        model.addAttribute("orders", orders);

        // Return the Orders view
        return "orders";
    }
}
