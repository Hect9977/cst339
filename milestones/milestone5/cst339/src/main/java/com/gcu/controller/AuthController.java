package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.business.AuthService;
import com.gcu.data.entity.UserEntity;
import com.gcu.models.LoginForm;
import com.gcu.models.RegisterForm;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

// AuthController class to handle user authentication, including registration and login
@Controller
public class AuthController {

    private final AuthService authService;

    // Constructor injection of AuthService
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Show registration form
    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("form", new RegisterForm());
        return "auth/register";
    }

    // Handle form submission for registration
    @PostMapping("/register")
    public String registerSubmit(@Valid @ModelAttribute("form") RegisterForm form,
            BindingResult result) {
        if (result.hasErrors())
            return "auth/register";
        boolean ok = authService.register(
                form.getFirstName(),
                form.getLastName(),
                form.getEmail(),
                form.getPassword());

        if (!ok) {
            result.reject("register", "That email is already registered.");
            return "auth/register";
        }
        return "redirect:/register/success";
    }

    // Show registration success page   
    @GetMapping("/register/success")
    public String registerSuccess() {
        return "auth/register-success";
    }

    // Show login form
    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("form", new LoginForm());
        return "auth/login";
    }

    // Handle form submission for login
    @PostMapping("/login")
    public String loginSubmit(@Valid @ModelAttribute("form") LoginForm form,
            BindingResult result,
            HttpSession session) {
        if (result.hasErrors())
            return "auth/login";

        UserEntity user = authService.login(form.getEmail(), form.getPassword());
        if (user == null) {
            result.reject("login", "Invalid email or password.");
            return "auth/login";
        }

        session.setAttribute("userId", user.getId());
        session.setAttribute("userEmail", user.getEmail());
        session.setAttribute("userName", user.getFirstName() + " " + user.getLastName());
        return "redirect:/dashboard";
    }

    // Handle logout by invalidating the session and redirecting to the home page
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
