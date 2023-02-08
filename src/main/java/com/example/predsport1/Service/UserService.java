package com.example.predsport1.Service;

import com.example.predsport1.Exception.UserNotFoundException;
import com.example.predsport1.Repository.UserRepository;
import com.example.predsport1.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User addUser(User user){
        System.out.print("ssdad");
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
