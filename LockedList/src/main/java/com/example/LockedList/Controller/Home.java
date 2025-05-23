package com.example.LockedList.Controller;

import com.example.LockedList.Entity.DTO.LoginInfo;
import com.example.LockedList.Entity.DTO.RegisterInfo;
import com.example.LockedList.Entity.UserRepo;
import com.example.LockedList.Services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @Autowired
    public UserRepo userRepo;
    public RegisterService register;
    public BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @GetMapping("/")
    public ResponseEntity<String> Home(){
            return ResponseEntity.ok("Hello");
    }
    @PostMapping("/register")
    public ResponseEntity<String> Regi(@RequestBody RegisterInfo Rinfo){
        try{
            register.register(Rinfo);
            return ResponseEntity.ok("User Registred");
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
