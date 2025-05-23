package com.example.SpringAuth.Service;

import com.example.SpringAuth.Model.User;
import com.example.SpringAuth.Repository.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class MyUserDetailsService implements UserDetailsService {
//checks if user in db or no
    @Autowired
    public Users users;

    @Override
    public  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User usr = users.findByUsername(username);
        if(usr == null){
            System.out.println("Username not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new UserPrincipal(usr);
    }
}