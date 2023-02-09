package com.example.predsport1.Service;

import com.example.predsport1.Exception.UserNotFoundException;
import com.example.predsport1.Repository.UserRepository;
import com.example.predsport1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private  UserRepository userReposistory;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public User findUserById(Long id){
        return userRepository.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));

    }
    public void deleteUser(Long id){
        userRepository.deleteUserById(id);

    }


}
