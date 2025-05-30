package com.rafademetrio.user_service.controllers;

import com.rafademetrio.user_service.dto.UserResponse;
import com.rafademetrio.user_service.repositories.UserRepository;
import com.rafademetrio.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return this.userService.findAll();
    }
}
