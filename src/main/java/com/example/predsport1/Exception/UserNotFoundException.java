package com.example.predsport1.Exception;

import com.example.predsport1.Repository.UserRepository;

public class UserNotFoundException extends RuntimeException {
    private UserRepository userReposistory;

    public UserNotFoundException(String message) {
        super(message);

    }
}
