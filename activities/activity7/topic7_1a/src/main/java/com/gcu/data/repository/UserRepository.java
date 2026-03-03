package com.gcu.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcu.data.entity.UserEntity;

// UserRepository interface for performing CRUD operations on UserEntity documents in MongoDB
public interface UserRepository extends MongoRepository<UserEntity, String> {
    UserEntity getUserByUsername(String username);
}
