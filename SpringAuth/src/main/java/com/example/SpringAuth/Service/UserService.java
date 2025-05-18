package com.example.SpringAuth.Service;

import com.example.SpringAuth.Model.User;
import com.example.SpringAuth.Repository.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {
@Autowired
private JWT jwt;

    private Users users;

    private AuthenticationManager authManager;
@Autowired
    public UserService(Users users, AuthenticationManager authManager) {
        this.users = users;
        this.authManager = authManager;
    }
    public String verify(User user){
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authentication.isAuthenticated()){
            return jwt.TokenGen(user.getUsername());
        }
        return "Fail";
    }
}