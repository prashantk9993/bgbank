package com.example.bgbank.controller;

import com.example.bgbank.model.User;
import com.example.bgbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // Create or Update User
   /* @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // Get all User
    *//*@GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> employees = userService.findAllUser();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }*//*

    // Get User by id
    @GetMapping
    public ResponseEntity<User> userLogin(@RequestParam String userName, @RequestParam String password) {
        User user = userService.findUser(userName,password);
        return  new ResponseEntity<>(user, HttpStatus.OK);
    }
*/
    // ----------------------------

    // Registration page
    @GetMapping("/register")
    public String showRegistrationForm() {
        System.out.println("Opening Registration page.........");
        return "register";
    }

    // Handle registration form submission
    @PostMapping("/register2")
    public String registerUser(User user) {
        System.out.println("Registering user.........");
        userService.saveUser(user);
        return "redirect:/welcome";
    }

    // Login page
    @GetMapping("/login")
    public String showLoginPage() {
        System.out.println("Opening Login page.........");
        return "login";
    }

    @PostMapping("/login2")
    public String checkUserLogin(User user) {
        System.out.println("user.getUserName()........"+user.getUserName());
        System.out.println("user.getPassword()........"+user.getPassword());

        System.out.println("Check user credentials.........");

        User user1 = userService.findUser(user.getUserName(),user.getPassword());

        if(user1!=null){
            System.out.println("Opening welcome page.........");

            return "redirect:/welcome";
        } else {
            System.out.println("Bad credentials.........");
            return "redirect:/login";
        }



    }

    @GetMapping("/welcome")
    public String showWelcomeage() {
        System.out.println("Opening welcome page.........");
        return "welcome";
    }

}
