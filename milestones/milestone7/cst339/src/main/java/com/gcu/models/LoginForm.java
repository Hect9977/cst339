package com.gcu.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

// LoginForm class representing the data submitted by the user during login
public class LoginForm {

    // Email field with validation to ensure it is not blank and is a valid email format
    @NotBlank @Email
    private String email;

    // Password field with validation to ensure it is not blank
    @NotBlank
    private String password;

    // Default constructor
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Getters and setters for email and password
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
