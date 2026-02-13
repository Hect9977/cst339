package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

// Dashboard controller
@Controller
public class DashboardController {
    // Show dashboard
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        Object email = session.getAttribute("loggedInEmail");
        if (email == null) {
            return "redirect:/login"; // simple “secure page” behavior
        }

        model.addAttribute("email", email);
        model.addAttribute("name", session.getAttribute("loggedInName"));
        return "dashboard/index";
    }
}
