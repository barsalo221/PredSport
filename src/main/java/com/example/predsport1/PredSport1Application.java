package com.example.predsport1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.example.predsport1.Repository")
public class PredSport1Application {

    public static void main(String[] args) {
        SpringApplication.run(PredSport1Application.class, args);
        System.out.println("sda");
    }

}
