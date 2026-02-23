package com.gcu.models;

public class User {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password; // Milestone 2 only (later: hash + DB)

    // Constructor
    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}