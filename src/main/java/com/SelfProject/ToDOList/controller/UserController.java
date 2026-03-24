package com.SelfProject.ToDOList.controller;

import com.SelfProject.ToDOList.dto.AuthRequest;
import com.SelfProject.ToDOList.model.User;
import com.SelfProject.ToDOList.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/api/v1/register")
    public void Register(@RequestBody User user) {
        userService.registerUser(user);
    }

    @PostMapping("/api/v1/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest auth) {
       String token =  userService.login(auth.getUsername(), auth.getPassword());
       if(token!=null){
           return ResponseEntity.ok(token);
       }
       else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
