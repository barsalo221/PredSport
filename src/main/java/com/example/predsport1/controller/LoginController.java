package com.example.predsport1.controller;

import com.example.predsport1.Service.UserServiceInterface;
import com.example.predsport1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class LoginController {

    UserServiceInterface userService;


    @Autowired
    public LoginController(UserServiceInterface userServiceInterface) {
        this.userService = userServiceInterface;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/", "/index", "/home"})
    public String getIndex() {
        return "index";
    }


    @GetMapping("/getusers")
    public String getAllStudents(Model model) {
        model.addAttribute("all_users", userService.getAllUsers());
        return "allusers";
    }

    /*
call to create a new student, this will call addusers.html, which
on return from this html file, it will call /students which is  "public String saveStudent"
which is a method in the StudentController.class (see below),
then "public String saveStudent" method will get the new entered student info and also the image file,
and it will call the studentService.saveStudent(student, file); to save the new student
 */
    @GetMapping("/users/new")
    public String addNewUserForm(Model model) {
        User user = new User();
        model.addAttribute("users", user);
        return "addusers";
    }

    @PostMapping("/users")
    public String saveStudent(@ModelAttribute("student") User user) {
        userService.saveUser(user);
        // redirect to url getStudents - see above ....@GetMapping("/getStudents") function
        return "redirect:/getusers";
    }
    //********************************************************

    /*
    call to update a student, this will call edit_student.html, which
    on return from this html file, it will call /students{id} which is  "public String updateStudent"
    which is a method in the StudentController.class (see below),
    then "public String updateStudent" method will get the updated student id, info and also the image file,
    and it will call the studentService.updateStudent(id, student, file); to save the updated student
    */
    @GetMapping("users/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", userService.getUserById(id));
        return "updateuser";
    }

    @PostMapping("/users/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("user") User user) {
        userService.updateUser(id, user);
        return "redirect:/getusers";
    }
    //*******************************************************

//    @GetMapping("/user/{id}")
//    public String deleteStudent(@PathVariable Long id) {
//        userService.deleteUser(id);
//        return "redirect:/getusers";
//    }
}
