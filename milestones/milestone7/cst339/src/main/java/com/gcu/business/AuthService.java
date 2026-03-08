package com.gcu.business;

import com.gcu.data.entity.UserEntity;

// AuthService interface defining methods for user registration and login
public interface AuthService {
    boolean register(String firstName, String lastName, String email, String password);
    UserEntity login(String email, String password);
}
