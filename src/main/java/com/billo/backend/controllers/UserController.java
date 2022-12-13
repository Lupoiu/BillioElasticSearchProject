package com.billo.backend.controllers;

import com.billo.backend.model.User;
import com.billo.backend.security.UserRequestVo;
import com.billo.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            return ResponseEntity.ok(userService.getAllUsers());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @PostMapping("/user/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRequestVo userRequestVo) {
        userService.registerNewUser(userRequestVo);
        return ResponseEntity.ok("User registered");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserRequestVo> getUserById(@PathVariable(name = "id") String id) {
        try {
            return ResponseEntity.ok(userService.getUserById(id));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable(name = "username") String username) {
        try {
            return ResponseEntity.ok(userService.getUserByUsername(username));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
