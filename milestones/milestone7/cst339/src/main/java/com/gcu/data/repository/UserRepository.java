package com.gcu.data.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gcu.data.entity.UserEntity;

// UserRepository interface for performing CRUD operations on the USERS table
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    @Query("SELECT * FROM USERS WHERE EMAIL = :email")
    Optional<UserEntity> findByEmail(@Param("email") String email);
}
