package com.example.bgbank.service;

import com.example.bgbank.model.User;
import com.example.bgbank.repo.UserRepo;
import com.example.bgbank.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    // Create or Update User
    public User saveUser(User user) {
        User newUser  = user;
        newUser.setPassword(UserUtil.encrypt(user.getPassword()));
        return userRepo.save(newUser);
    }


    public User findUser(String userName,String password) {
       String passsword =   UserUtil.encrypt(password);
       User user =  userRepo.findByUserName(userName);
       if(user.getPassword().equals(passsword)){
           return user;
       }
       return null;
    }

    public List<User> findAllUser() {
        return userRepo.findAll();
    }

}
