package com.example.SpringAuth.Controllers;

import com.example.SpringAuth.Model.User;
import com.example.SpringAuth.Repository.Users;
import com.example.SpringAuth.Service.MyUserDetailsService;
import com.example.SpringAuth.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserCont {
    @Autowired
    private Users users;
    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @PostMapping("/addusers")
    public User Add(@RequestBody User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return users.save(user);
    }
    @GetMapping("/users")
    public List<User> getd(){
        return users.findAll();
    }
    @PostMapping("/login")
    public String login(@RequestBody User user){
        System.out.println(user);
        return userService.verify(user);
    }
}
