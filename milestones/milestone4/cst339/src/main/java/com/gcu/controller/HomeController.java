package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// HomeController class to handle requests for the home page
@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String home() {
        return "home/index"; // matches templates/home/index.html
    }
}
