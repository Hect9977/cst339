package com.gcu.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UserRepository;

// Dashboard controller
@Controller
public class DashboardController {

    private final UserRepository userRepository;

    public DashboardController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication, Model model) {
        String email = authentication.getName();
        String name = email;

        UserEntity user = userRepository.findByEmail(email).orElse(null);
        if (user != null) {
            name = user.getFirstName() + " " + user.getLastName();
        }

        model.addAttribute("email", email);
        model.addAttribute("name", name);
        return "dashboard/index";
    }
}
