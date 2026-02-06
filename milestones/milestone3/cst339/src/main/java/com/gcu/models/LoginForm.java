package com.gcu.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

// Login form model
public class LoginForm {
    // Email field
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    // Password field
    @NotBlank(message = "Password is required")
    private String password;

    // Getters and setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
