package com.codewithrufu.springboot.springfirstwebapp.login;


import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String name, String password) {
        return name.equals("rufu") && password.equals("hello");
    }
}
