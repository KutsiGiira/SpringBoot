package com.example.LockedList.Controller;

import com.example.LockedList.Entity.DTO.LoginInfo;
import com.example.LockedList.Entity.DTO.RegisterInfo;
import com.example.LockedList.Entity.UserRepo;
import com.example.LockedList.Entity.Users;
import com.example.LockedList.Jwt.JwtUtil;
import com.example.LockedList.Services.LoginService;
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
    public LoginService loginService;
    @Autowired
    public RegisterService register;
    @Autowired
    public JwtUtil jwtUtil;
    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;
    public BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @GetMapping("/")
    public ResponseEntity<String> Home(){
        try{
            return ResponseEntity.ok("Hello");
        }
    catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("KHRITI");
        }
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
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginInfo Linfo) {
        try {
            Users user = loginService.Verify(Linfo.getUsername());
            if (!bCryptPasswordEncoder.matches(Linfo.getPassword(), user.getPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
            }
            String token = jwtUtil.TokenGen(user.getUsername());
            System.out.println(token);
            return ResponseEntity.ok(Linfo.getToken());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}