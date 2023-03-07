package com.example.predsport1.Service;

import com.example.predsport1.Repository.UserRepository;
import com.example.predsport1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface{
    UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findUserById(id).get();
    }

    @Override
    public User updateUser(Long id, User user) {
        User getUserFromDatabase = getUserById(id);
        getUserFromDatabase.setId(user.getId());
        getUserFromDatabase.setEmail(user.getEmail());
        getUserFromDatabase.setName(user.getName());
        getUserFromDatabase.setUsername(user.getUsername());
        getUserFromDatabase.setPassword(user.getPassword());

        return userRepository.save(getUserFromDatabase);
    }
}
