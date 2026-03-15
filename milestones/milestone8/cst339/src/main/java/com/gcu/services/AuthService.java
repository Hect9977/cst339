package com.gcu.services;

import com.gcu.models.RegisterForm;
import com.gcu.models.User;

/**
 * Defines authentication-related business operations.
 */
public interface AuthService {
    User register(RegisterForm form);
    User login(String email, String password);
}
