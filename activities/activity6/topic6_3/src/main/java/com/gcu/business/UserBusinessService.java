package com.gcu.business;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcu.data.UsersDataService;
import com.gcu.data.entity.UserEntity;

// UserBusinessService is a service class that implements the UserDetailsService interface to provide user authentication functionality
@Service
public class UserBusinessService implements UserDetailsService {

    // UsersDataService is injected into the UserBusinessService to access user data
    // for authentication purposes
    private final UsersDataService service;

    // Constructor for UserBusinessService that takes a UsersDataService as a
    // parameter
    public UserBusinessService(UsersDataService service) {
        this.service = service;
    }

    // Implementation of the loadUserByUsername method from the UserDetailsService
    // interface
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = service.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return User.withUsername(user.getUsername())
                .password(user.getPassword()) // already BCrypt in MongoDB
                .roles("USER")
                .build();
    }
}