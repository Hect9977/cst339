package com.gcu.services;

import com.gcu.models.RegisterForm;
import com.gcu.models.User;

public interface AuthService {
    User register(RegisterForm form);
    User login(String email, String password);
}
