package com.example.predsport1.entity;


import com.example.predsport1.Repository.UserRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false,updatable = false)
    private String username;

    @Column(nullable = false)
    private String password;
    private String name;
    private String email;

    private UserRepository userReposistory;


}