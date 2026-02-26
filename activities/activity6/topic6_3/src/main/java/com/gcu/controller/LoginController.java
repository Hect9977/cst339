package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Removed class request mapping to /login
//Removed the doLogin() method (save it for later)
// This controller is just for displaying the login page. Spring Security will handle the actual login process.
@Controller
public class LoginController {

    @GetMapping("/login")
    public String display() {
        return "login";
    }
}