package com.example.bgbank.util;

import com.example.bgbank.model.User;
import org.mindrot.jbcrypt.BCrypt;

public class UserUtil {
    public static String encrypt(String password){

        System.out.println("Plain password :::::::"+password);
        String enc_pwd = BCrypt.gensalt();
        System.out.println("Encrypted password :::::::"+enc_pwd);
        return BCrypt.hashpw(password, enc_pwd);
    }
}
