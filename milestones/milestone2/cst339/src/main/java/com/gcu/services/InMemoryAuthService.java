package com.gcu.services;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.gcu.models.RegisterForm;
import com.gcu.models.User;

// In-memory authentication service
@Service
public class InMemoryAuthService {

    // Store users by email
    private final ConcurrentHashMap<String, User> usersByEmail = new ConcurrentHashMap<>();

    // Register a new user
    public User register(RegisterForm form) {
        User user = new User(
                form.getFirstName(),
                form.getLastName(),
                form.getEmail(),
                form.getPassword()
        );
        usersByEmail.put(form.getEmail().toLowerCase(), user);
        return user;
    }

    // Login a user
    public User login(String email, String password) {
        if (email == null) return null;
        User user = usersByEmail.get(email.toLowerCase());
        if (user == null) return null;
        return user.getPassword().equals(password) ? user : null;
    }
}
