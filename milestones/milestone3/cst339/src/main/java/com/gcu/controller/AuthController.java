package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.models.LoginForm;
import com.gcu.models.RegisterForm;
import com.gcu.models.User;
import com.gcu.services.InMemoryAuthService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

// Authentication controller
@Controller
public class AuthController {

    private final InMemoryAuthService authService;

    public AuthController(InMemoryAuthService authService) {
        this.authService = authService;
    }
    // Show registration form
    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("form", new RegisterForm());
        return "auth/register";
    }
    // Handle registration form submission
    @PostMapping("/register")
    public String doRegister(@Valid @ModelAttribute("form") RegisterForm form,
                             BindingResult bindingResult,
                             HttpSession session) {

        // Simple confirm-password check (validation rule)
        if (form.getPassword() != null && !form.getPassword().equals(form.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "match", "Passwords must match");
        }

        if (bindingResult.hasErrors()) {
            return "auth/register";
        }

        User user = authService.register(form);
        session.setAttribute("registeredEmail", user.getEmail());
        return "redirect:/register/success";
    }
    // Show registration success page
    @GetMapping("/register/success")
    public String registerSuccess(HttpSession session, Model model) {
        model.addAttribute("email", session.getAttribute("registeredEmail"));
        return "auth/register-success";
    }
    // Show login form
    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("form", new LoginForm());
        return "auth/login";
    }
    // Handle login form submission
    @PostMapping("/login")
    public String doLogin(@Valid @ModelAttribute("form") LoginForm form,
                          BindingResult bindingResult,
                          HttpSession session) {

        if (bindingResult.hasErrors()) {
            return "auth/login";
        }

        User user = authService.login(form.getEmail(), form.getPassword());
        if (user == null) {
            bindingResult.reject("invalid", "Invalid email or password");
            return "auth/login";
        }

        session.setAttribute("loggedInEmail", user.getEmail());
        session.setAttribute("loggedInName", user.getFirstName());
        return "redirect:/dashboard";
    }
    // Handle logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
