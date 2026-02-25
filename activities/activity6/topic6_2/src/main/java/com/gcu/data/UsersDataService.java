package com.gcu.data;

import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UserRepository;

// UsersDataService is a service class that implements the UserdataAccessInterface to provide user data access functionality
@Service
public class UsersDataService implements UserdataAccessInterface<UserEntity> {

    // UserRepository is injected into the UsersDataService to perform database
    // operations related to UserEntity
    private final UserRepository userRepository;

    // Constructor for UsersDataService that takes a UserRepository as a parameter
    public UsersDataService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Implementation of the findByUsername method from the UserdataAccessInterface
    // that retrieves a UserEntity based on the provided username using the
    // UserRepository
    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
}