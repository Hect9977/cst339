package com.gcu.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterForm {

    // First name field with validation to ensure it is not blank
    @NotBlank
    private String firstName;

    // Last name field with validation to ensure it is not blank
    @NotBlank
    private String lastName;

    // Email field with validation to ensure it is not blank and is a valid email format
    @NotBlank @Email
    private String email;

    // Password field with validation to ensure it is not blank and has a minimum length of 4 characters
    @NotBlank
    @Size(min = 4, message = "Password must be at least 4 characters")
    private String password;

    // Confirm password field with validation to ensure it is not blank and has a minimum length of 4 characters
    @NotBlank
    @Size(min = 4, message = "Password must be at least 4 characters")
    private String confirmPassword;

    // Getters and setters for all fields
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }
}
