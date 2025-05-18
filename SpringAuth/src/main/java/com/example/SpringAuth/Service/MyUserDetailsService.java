package com.example.SpringAuth.Service;

import com.example.SpringAuth.Model.User;
import com.example.SpringAuth.Repository.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    public Users users;

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if(user == null){
            System.out.println("Username not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new UserPrincipal(user);
    }
}
