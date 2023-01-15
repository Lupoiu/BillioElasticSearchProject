package com.billo.backend.controllers;


import com.billo.backend.exceptions.UserDoesntExistException;
import com.billo.backend.model.User;
import com.billo.backend.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    @ApiOperation(value = "This endpoint will return all the users", notes = "This endpoint will return all the users",nickname = "getAllUsers")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code =404,message = "Not Found"),
            @ApiResponse(code = 200, message = "Successful",
            response = User.class,responseContainer = "List"),
            @ApiResponse(code = 401, message = "Unauthorized user")
    })
    public ResponseEntity<?> getAllUsers() throws Exception {
        try {
            return ResponseEntity.ok(userService.getAllUsers());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(String.format("There was a problem: %s",ex.getMessage()));
        }
    }

    @GetMapping("/user/{username}")
    @ApiOperation(value = "This endpoint will return a users", notes = "The user is able to search another user in our application, by the username of said user",nickname = "getUserByUsername")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code =404,message = "Not Found"),
            @ApiResponse(code = 200, message = "Successful",
                    response = User.class),
            @ApiResponse(code = 401, message = "Unauthorized user")
    })
    public ResponseEntity<User> getUserByUsername(@ApiParam(value = "username",required = true) @PathVariable(name = "username") String username) {
        try {
            return ResponseEntity.ok(userService.getUserByUsername(username));
        } catch (UserDoesntExistException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }catch (Exception ex) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
