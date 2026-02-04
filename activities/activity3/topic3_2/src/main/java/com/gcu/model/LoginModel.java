package com.gcu.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginModel {

    @NotNull(message = "User Name is required")
    @Size(min = 1, max = 32, message = "User Name must be 1 to 32 characters")
    private String username;

    @NotNull(message = "Password is required")
    @Size(min = 1, max = 32, message = "Password must be 1 to 32 characters")
    private String password;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
