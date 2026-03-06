package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UserRepository;
import com.gcu.models.UserModel;

// UserBusinessService class responsible for handling business logic related to users
@Service
public class UserBusinessService {

    // Repository for performing CRUD operations on UserEntity documents in MongoDB
    private final UserRepository service;

    // Constructor to initialize the UserBusinessService with a UserRepository
    // instance
    public UserBusinessService(UserRepository service) {
        this.service = service;
    }

    // Method to retrieve all users from the database and convert them to UserModel
    // instances
    public List<UserModel> getAllUsers() {
        List<UserEntity> entities = service.findAll();
        List<UserModel> users = new ArrayList<>();

        for (UserEntity entity : entities) {
            users.add(new UserModel(
                    entity.getId(),
                    entity.getUsername(),
                    entity.getPassword()));
        }

        return users;
    }
}