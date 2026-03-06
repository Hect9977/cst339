package com.gcu.models;

// UserModel class representing a user in the application
public class UserModel {
    private String id;
    private String username;
    private String password;

    // Default constructor initializing fields to empty strings
    public UserModel() {
        this.id = "";
        this.username = "";
        this.password = "";
    }

    // Constructor to initialize the UserModel with specific values
    public UserModel(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // Getters and setters for the fields
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
