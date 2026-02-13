package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Home controller
@Controller
public class HomeController {
    // Show home page
    @GetMapping("/")
    public String home() {
        return "home/index";
    }
}
