package com.gcu.data;

// UserdataAccessInterface is a generic interface for accessing user data based on username
public interface UserdataAccessInterface<T> {
    T findByUsername(String username);
}
