package com.example.bgbank.service;

import com.example.bgbank.model.User;
import com.example.bgbank.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    // Create or Update User
    public User saveUser(User user) {
        User newUser = user;
        //newUser.setPassword(UserUtil.encrypt(user.getPassword()));
        int max = 9999, min = 1000;
        newUser.setCustRegNumber(StringUtils.substring(user.getFirstName(), 0, 1)
                + "" + StringUtils.substring(user.getLastName(), 0, 3)
                + ":" + min + (int) (Math.random() * ((max - min) + 1)));
        return userRepo.save(newUser);
    }


    public User findUser(String userName, String password) {
        //String passsword =   UserUtil.encrypt(password);
        try {
            User user = userRepo.findByUserName(userName);
            if (user.getPassword().equals(password)) {
                return user;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> findAllUser() {
        return userRepo.findAll();
    }

}
