package com.gcu.services;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.gcu.models.RegisterForm;
import com.gcu.models.User;

// In-memory implementation of AuthService for demonstration purposes
@Service
public class InMemoryAuthService implements AuthService {

    // Using ConcurrentHashMap for thread-safe access to user data
    private final ConcurrentHashMap<String, User> usersByEmail = new ConcurrentHashMap<>();

    // Register a new user and store them in the map
    @Override
    public User register(RegisterForm form) {
        User user = new User(form.getFirstName(), form.getLastName(), form.getEmail(), form.getPassword());
        usersByEmail.put(form.getEmail().toLowerCase(), user);
        return user;
    }

    // Authenticate a user by email and password
    @Override
    public User login(String email, String password) {
        if (email == null) return null;
        User user = usersByEmail.get(email.toLowerCase());
        if (user == null) return null;
        return user.getPassword().equals(password) ? user : null;
    }
}
