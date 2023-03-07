package com.example.predsport1.Service;

import com.example.predsport1.entity.User;

import java.util.List;

public interface UserServiceInterface {

    List<User> getAllUsers();

    User saveUser(User user);

    User getUserById(Long id);

    User updateUser(Long id, User user);
}
