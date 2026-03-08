package com.gcu.business;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UserRepository;

// AuthServiceImpl class implementing the AuthService interface to handle user registration and login logic
@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Method to register a new user, checks if the email already exists and saves the new user if it does not
    @Override
    public boolean register(String firstName, String lastName, String email, String password) {
        Optional<UserEntity> existing = userRepository.findByEmail(email);
        if (existing.isPresent()) {
            return false;
        }

        UserEntity user = new UserEntity(null, email, passwordEncoder.encode(password), firstName, lastName);
        userRepository.save(user);
        return true;
    }

    // Optional helper method retained for compatibility with prior milestone code
    @Override
    public UserEntity login(String email, String password) {
        Optional<UserEntity> userOpt = userRepository.findByEmail(email);
        if (userOpt.isEmpty()) {
            return null;
        }

        UserEntity user = userOpt.get();
        return passwordEncoder.matches(password, user.getPassword()) ? user : null;
    }
}
