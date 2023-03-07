package com.example.predsport1.DataTransferObject;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



/*
The "UserDto" class is a helper class to be used in "Html form to Controller communication"
when a new user is registered in the system.
DTO -> Data Transfer Object
https://en.wikipedia.org/wiki/Data_transfer_object
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {


    private Long id;

    @NotEmpty
    private String username;

    @NotEmpty(message = "Password should not be empty")
    private String password;
    @NotEmpty
    private String name;

    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;
}
