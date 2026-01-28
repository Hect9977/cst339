package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/login")
public class LoginController {

    // Handles GET /login and GET /login/
    @GetMapping({ "", "/" })
    public String display(Model model) {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }

    // POST /login/doLogin
@PostMapping("/doLogin")
public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult,Model model) {

    // If validation errors, go back to login
    if (bindingResult.hasErrors()) {
        model.addAttribute("title", "Login Form");
        return "login";
    }

    // Printing the form values out
    System.out.println(String.format("Username: %s and Password of: %s",loginModel.getUsername(), loginModel.getPassword()));

    // Creating the default orders
    List<OrderModel> orders = new ArrayList<>();
    orders.add(new OrderModel(1L, "A0001", "Keyboard", 29.99f, 1));
    orders.add(new OrderModel(2L, "A0002", "Mouse", 14.99f, 2));
    orders.add(new OrderModel(3L, "A0003", "Monitor", 199.99f, 1));

    // Setting the model attributes
    model.addAttribute("title", "My Orders");
    model.addAttribute("orders", orders);

    // Return the Orders view
    return "orders";
}
    
}
